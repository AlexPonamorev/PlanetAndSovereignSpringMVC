package com.example.TaskSpringBoot1.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {  // это для работы с папкой static

    @Override

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/"); // к папке img обращаться /img/**
    }
//
//    @Bean
//    public FilterRegistrationBean someFilterRegistration() {
//
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(someFilter());
//        registration.addUrlPatterns("/url/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("someFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//
//    public Filter someFilter() {
//        return new SomeFilter();
//    }

}
