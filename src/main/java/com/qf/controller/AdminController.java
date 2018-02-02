package com.qf.controller;


import com.qf.pojo.User;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/login")
    public ModelAndView login(User user, HttpServletRequest request){
        User admin = adminService.getAdmin(user);
        request.getSession().setAttribute("admin",admin);
        return new ModelAndView("admin/index");
    }

    @RequestMapping("/admin/logout")
    public ModelAndView logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelAndView("redirect:/admin/index.jsp");
    }
}
