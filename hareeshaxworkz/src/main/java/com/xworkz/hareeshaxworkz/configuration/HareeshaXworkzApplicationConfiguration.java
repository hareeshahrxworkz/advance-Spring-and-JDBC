package com.xworkz.hareeshaxworkz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.hareeshaxworkz")
public class HareeshaXworkzApplicationConfiguration {
	public HareeshaXworkzApplicationConfiguration() {
		System.out.println("Running " + getClass().getSimpleName());
	}

	@Bean
	public ViewResolver resolver() {
		System.out.println("register view Resolver");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		System.out.println("Running localcontinerentity manager factory bean");
		return new LocalContainerEntityManagerFactoryBean();
	}

}
