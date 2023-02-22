package com.xworkz.park.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz")
public class ParkConfiguration {
	public ParkConfiguration() {
		System.out.println("Running Park Configuration");
	}

	@Bean
	public ViewResolver resolver() {
		System.out.println("egister view Resolver");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean

	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		System.out.println("register localContainerEntityManagerFactoryBean");
		return new LocalContainerEntityManagerFactoryBean();
	}

}
