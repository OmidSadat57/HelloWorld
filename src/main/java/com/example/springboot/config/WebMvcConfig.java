package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController(Endpoints.GETCITIES).setViewName(ViewNames.TEST);

        registry.addViewController(Endpoints.GETCITIES).setViewName(ViewNames.WUNSCHSTADT);
//        registry.addViewController(Endpoints.GETCITIES).setViewName(ViewNames.TEST);
    }
}
