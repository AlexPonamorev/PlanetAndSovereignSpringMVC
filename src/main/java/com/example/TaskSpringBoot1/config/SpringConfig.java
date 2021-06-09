package com.example.TaskSpringBoot1.config;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//
//@Configuration
//@ComponentScan("com.example.TaskSpringBoot1")
//@EnableWebMvc
//public class SpringConfig implements WebMvcConfigurer {
//
//    private final ApplicationContext applicationContext;
//
//    @Autowired
//    public SpringConfig(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
////        templateResolver.setPrefix("/WEB-INF/views/");src/main/resources
//        templateResolver.setPrefix("/resources/templates/");
//        templateResolver.setSuffix(".html");
//        return templateResolver;
//    }
////    registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
////        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
////        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
////        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/"); // к папке img обращаться /img/**
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        registry.viewResolver(resolver);
//    }
//}
