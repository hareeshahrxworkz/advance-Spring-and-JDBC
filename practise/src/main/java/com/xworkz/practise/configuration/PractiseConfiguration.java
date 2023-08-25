package com.xworkz.practise.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.practise")
public class PractiseConfiguration {

	public PractiseConfiguration() {
		System.out.println("Running Practise Controller");

	}
	@Bean
	
	public ViewResolver resolver() {

		System.out.println("Running resolvour");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		System.out.println("Running localcontinerentity manager factory bean");
		return new LocalContainerEntityManagerFactoryBean();
	}
	
	
	
}
