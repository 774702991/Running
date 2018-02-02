package com.qf.controller;

import com.qf.pojo.Circle;
import com.qf.service.CircleService;
import com.qf.util.JsonUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/circle")
public class CircleController {

    private String BLOG_IMAGE_DIR = "/usr/local/tomcat/webapps/upload";   //存储路径
    private String BLOG_IMAGE_URL = "http://www.zjs91.cn/upload/";     //访问路径

    @Autowired
    private CircleService circleService;

    @RequestMapping("add")
    @ResponseBody
    public Map<String,Object> add(Circle circle, @RequestParam("file") MultipartFile file, HttpServletRequest request){
        System.out.println(circle);
        //MultipartFile file = circle.getFile();
        String oldName = file.getOriginalFilename();
        String extName = oldName.substring(oldName.lastIndexOf("."));
        String newName = System.currentTimeMillis() + extName;
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(BLOG_IMAGE_DIR,newName));
            String img = BLOG_IMAGE_URL + newName;
            System.out.println(img);
            circle.setImg(img);
            Cookie[] cookies = request.getCookies();
            if (cookies!=null && cookies.length !=0){
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userid")){
                        //System.out.println(cookie.getName()+"`````````"+cookie.getValue());
                        circle.getUserInfo().getUser().setId(Integer.parseInt(cookie.getValue()));
                        circleService.addCircle(circle);
                        return JsonUtil.getSuccess("添加成功",null);
                    }
                }
            }
            return JsonUtil.getError("请先登录");
        } catch (IOException e) {
            e.printStackTrace();
            return JsonUtil.getError("添加失败");
        }
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(){
        List<Circle> list = circleService.getCircle();
        return JsonUtil.getSuccess("查询成功",list);
    }

    @RequestMapping("find")
    public ModelAndView find(){
        List<Circle> list = circleService.getCircleAndUser();
        return new ModelAndView("/admin/circle","list",list);
    }

    @RequestMapping("del")
    public String del(Integer id, Model model){
        if (id!=null){
            circleService.delCircle(id);
            return "redirect:/api/circle/find";
        }
        return "redirect:/api/circle/find";
    }
}
