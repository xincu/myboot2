package com.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class Logininterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod had = (HandlerMethod) handler;
            Method md = had.getMethod();
            login lo = md.getAnnotation(login.class);
          /*存在注解时候才能获取*/
            if (lo != null) {
                boolean cklogin = lo.check();
                if (cklogin) {
                    boolean ck2 = checklogin(request);
                    if (ck2 = false) {
                        response.sendRedirect("/myboot/login.jsp");
                        return false;
                    }

                }

            }
        }
        return  true;
    }

        /*登陆判断*/




    private boolean checklogin(HttpServletRequest request) {
        Object uobj = request.getSession().getAttribute("userinfo");
        if (uobj != null) {
            return true;
        } else {

            return false;
        }
    }
}
