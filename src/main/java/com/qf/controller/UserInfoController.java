package com.qf.controller;

import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> add(UserInfo userInfo){
        if (userInfo.getUser()!=null){
            userInfoService.addUserInfo(userInfo);
            return JsonUtil.getSuccess("添加成功",userInfo);
        }
        return JsonUtil.getError("添加失败");
    }

    @RequestMapping("/user_info")
    @ResponseBody
    public Map<String,Object> get(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length!=0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userid")){
                    UserInfo userInfo = userInfoService.getUserInfoById(Integer.parseInt(cookie.getValue()));
                    return JsonUtil.getSuccess("查询成功",userInfo);
                }
            }
            return JsonUtil.getError("请登录");
        }
        return JsonUtil.getError("请登录");
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(UserInfo userInfo,HttpServletRequest request){
        System.out.println(userInfo.toString());
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length!=0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userid")){
                    if (userInfo!=null && userInfo.getUser()!=null){
                        userInfo.getUser().setId(Integer.parseInt(cookie.getValue()));
                        userInfoService.updateUserInfo(userInfo);
                        System.out.println(userInfo.toString());
                        return JsonUtil.getSuccess("编辑成功",userInfo);
                    }
                }
            }
        }
        return JsonUtil.getError("请登录");
    }

    @RequestMapping("list")
    public ModelAndView list(){
        List<UserInfo> list = userInfoService.getUser();
        return new ModelAndView("/admin/user_info","list",list);
    }
}
