package com.my.contoller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.my.controller")
public class WebConfig extends WebMvcConfigurerAdapter 
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
			if (!registry.hasMappingForPattern("/js/**")) {
				registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
			}
			if (!registry.hasMappingForPattern("/app/**")) {
				registry.addResourceHandler("/app/**").addResourceLocations("classpath:/app/");
			}
			if (!registry.hasMappingForPattern("/node_modules/**")) {
				registry.addResourceHandler("/node_modules/**").addResourceLocations("classpath:/node_modules/");
			}
		}
	}

	@Bean
	public InternalResourceViewResolver internalViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		return viewResolver;
	}
}