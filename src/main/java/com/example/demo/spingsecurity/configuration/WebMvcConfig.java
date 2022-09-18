package com.example.demo.spingsecurity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import thymeleaf.ThymeleafLayoutInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login/form").setViewName("login");
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ThymeleafLayoutInterceptor());
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

}