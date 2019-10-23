package com.action;
import  java.util.*;
import  com.dao.*;
import  com.entity.*;
import com.interceptor.login;
import  com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
   @Autowired
   private  IUsersService is;
   @RequestMapping("/test")
    public ModelAndView test(ModelAndView mav){
        System.out.print("-------test");
        mav.setViewName("success");
        return  mav;
    }
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mav, UserBean u, HttpSession session) {
        System.out.print("-------test");
        if ("管理员".equals(u.getName())&&"admin".equals(u.getPwd())){
            session.setAttribute("userinfo",u);
            mav.setViewName("success");
        }else {
            mav.addObject("loginerror","用户错误");
            mav.setViewName("login");
        }

        return mav;
    }
    @login(check=true)
    @RequestMapping("/main")
    public ModelAndView main(ModelAndView mav){
        System.out.print("-------main");


        mav.setViewName("success");
        return  mav;
    }

}
