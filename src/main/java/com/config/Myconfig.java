package com.config;

import com.interceptor.BaseInterceptor;
import com.interceptor.Logininterceptor;
import com.interceptor.Tokeninterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Myconfig implements WebMvcConfigurer {

    @Override//添加拦截器（不是拦截器）
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/test");
        registry.addInterceptor(new Logininterceptor()).addPathPatterns("/*");
        registry.addInterceptor(new Tokeninterceptor()).addPathPatterns("/*");
    }
}
