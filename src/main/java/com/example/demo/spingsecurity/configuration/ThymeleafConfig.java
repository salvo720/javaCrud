package com.example.demo.spingsecurity.configuration;

import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

public class ThymeleafConfig {

	@Bean
	public SpringTemplateEngine templateEngine(final ServletContextTemplateResolver resolver) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(resolver);
		engine.setAdditionalDialects(new HashSet<IDialect>() {
			{
				add(new LayoutDialect());
				add(new SpringSecurityDialect());
			}
		});
		return engine;
	}

}
