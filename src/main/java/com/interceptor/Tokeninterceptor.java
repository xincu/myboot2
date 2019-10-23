package com.interceptor;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class Tokeninterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod had = (HandlerMethod) handler;
            Method md = had.getMethod();
            Token token = md.getAnnotation(Token.class);
            if (token!=null){

                boolean cktoken=token.check();

                if (cktoken){
                    boolean ck2= checktoken(request);
                   if (ck2==false) {
                       response.sendRedirect("/myboot/repost.jsp");
                       return false;
                   }else{
                       //晴空token
                       request.getSession().removeAttribute("token");

                   }
                }

            }



        }
        return true;
    }
    private  boolean checktoken(HttpServletRequest request){
       boolean ck=false;
       String  rnum =request.getParameter("token");
       Object snum=request.getSession().getAttribute("token");
       if (rnum!=null&&snum!=null&&rnum==snum) {
           ck = true;
       }
        return ck;
    }
}
