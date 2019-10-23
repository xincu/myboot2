package com.interceptor;

import com.entity.UserBean;
import com.service.IUsersService;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.transaction.TransactionUsageException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=====进入controller");
       /*在无法注入的情况下如何获取spring的上下文*/
       /*ApplicationContext ctx= WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext())*/;
        IUsersService us=(IUsersService) (getBean("UserService",request.getServletContext()));
        System.out.println("*********UserService="+us);

        return true;
    }
    /*建造一个私有方法*/
    private Object getBean(String  name , ServletContext ctx)throws Exception{
        ApplicationContext ct= WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
     return  ct.getBean(name);


    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("出controller");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("进入view");
    }

}
