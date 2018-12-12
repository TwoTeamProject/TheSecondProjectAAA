package com.pro.two;

import com.pro.two.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * className:com.pro.two.MvcConfigClass
 * discription:
 * author:sjq
 * createTime:2018-11-27 22:17
 */
@SpringBootConfiguration
public class MvcConfigClass implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加自定义拦截器  配置拦截路径addPathPatterns和不拦截的路径excludePathPatterns
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/toLogin","/login/inLogin");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
