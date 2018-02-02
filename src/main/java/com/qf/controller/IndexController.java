package com.qf.controller;

import com.qf.service.UserInfoService;
import com.qf.util.JsonUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class IndexController {
    //http://www.zjs91.cn/upload/
    private String BLOG_IMAGE_DIR = "/usr/local/tomcat/webapps/upload";   //存储路径
    private String BLOG_IMAGE_URL = "http://www.zjs91.cn/upload/";     //访问路径
    //private String UPLOAD = "http://www.zjs91.cn/upload/";

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/api/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        System.out.println(file);
        Cookie[] cookies = request.getCookies();
        if (cookies!=null||cookies.length!=0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userid")){
                    String oldName = file.getOriginalFilename();
                    String extName = oldName.substring(oldName.lastIndexOf("."));
                    String newName = System.currentTimeMillis() + extName;
                    try {
                        FileUtils.copyInputStreamToFile(file.getInputStream(),new File(BLOG_IMAGE_DIR,newName));
                        String img = BLOG_IMAGE_URL+newName;
                        userInfoService.updateUserInfoImg(img,Integer.parseInt(cookie.getValue()));
                        return JsonUtil.getSuccess("头像上传成功",img);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return JsonUtil.getError("头像上传失败");
                    }
                }
            }
            return JsonUtil.getError("请登录");
        }
        return JsonUtil.getError("请登录");
    }
    /*@RequestMapping("/index")
    @ResponseBody
    public Map<String,Object> list() throws GlobalExceptions {
        Map<String,Object> map = new HashMap<>();
        Date date = DateUtil.getFirstDayOfWeek(new Date());
        Date date1 = DateUtil.getLastDayOfWeek(new Date());
        String mon = DateUtil.formatDateTime(date);
        String week = DateUtil.formatDateTime(date1);
        List<Movement> list =indexService.getIndexWeek(mon,week);
        map.put("ret",true);
        map.put("data",null);
        map.put("movement",list);
        return map;
    }*/

    /*@RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> add(Movement movement) throws GlobalExceptions{
        if (movement.getUser().getId()!=null){
            indexService.addIndexWeek(movement);
            return JsonUtil.getSuccess("添加成功",null);
        }
        return JsonUtil.getError("添加失败");
    }*/
}
