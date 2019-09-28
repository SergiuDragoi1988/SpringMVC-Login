package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").
                addResourceLocations("WEB-INF/img/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());

        registry.addResourceHandler("/css/**")
                .addResourceLocations("WEB-INF/css/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }
    @Bean
    public ClassLoaderTemplateResolver templateResolver(){
        ClassLoaderTemplateResolver resolver =  new ClassLoaderTemplateResolver();
        resolver.setPrefix("mytemplates/");
        resolver.setSuffix(".html");
        return resolver;
    }
}
