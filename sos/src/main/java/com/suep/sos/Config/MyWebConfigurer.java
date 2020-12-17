package com.suep.sos.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyWebConfigurer implements WebMvcConfigurer {

    @Bean
//    public LoginInterceptor getLoginInterceptor(){
////        return new LoginInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor()
    }
}
