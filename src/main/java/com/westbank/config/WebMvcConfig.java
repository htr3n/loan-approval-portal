package com.westbank.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@ComponentScan({
        "com.westbank.web",
        "com.westbank.web.controller",
        "com.westbank.web.validator",
        "com.westbank.web.form"
})
@PropertySource("classpath:endpoint.properties")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


    private static final String VIEW_PREFIX = "/WEB-INF/jsp/";
    private static final String VIEW_SUFFIX = ".jsp";

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp(VIEW_PREFIX, VIEW_SUFFIX);
    }
}
