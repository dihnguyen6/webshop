package com.mrKhoai.webshop.beta;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home-02");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/admin").setViewName("admin/loginAdmin");
        registry.addViewController("/error").setViewName("error");
    }

}
