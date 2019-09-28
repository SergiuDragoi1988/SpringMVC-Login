package com.example.demoSpring;

import com.example.demoSpring.beans.MyBean;
import com.example.demoSpring.beans.SecondName;
import com.example.demoSpring.config.AppConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@SpringBootApplication
public class DemoSpringApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(DemoSpringApplication.class);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**")
				.addResourceLocations("/WEB-INF/img/")
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
		registry.addResourceHandler("/css/**")
				.addResourceLocations("/WEB-INF/css/")
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(AppConfig.class);
//		context.refresh();
//
//		MyBean bean = context.getBean(MyBean.class);
//		System.out.println(bean.sayHello());
//
//		bean.setName(new SecondName());
//		System.out.println(bean.sayHello());
//	}
}
