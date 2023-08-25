package com.xworkz.email.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.email")
public class EmailApplicationConfiguration {

	public EmailApplicationConfiguration() {
		System.out.println("Running" + getClass().getSimpleName());
	}

	@Bean
	public ViewResolver resolver() {
		System.out.println("Running View Resolver");

		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean

	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		return new LocalContainerEntityManagerFactoryBean();
	}

}
