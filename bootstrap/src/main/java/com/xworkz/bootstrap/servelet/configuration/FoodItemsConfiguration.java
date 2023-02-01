package com.xworkz.bootstrap.servelet.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@ComponentScan("com.xworkz.bootstrap.servelet")
public class FoodItemsConfiguration {
	public FoodItemsConfiguration() {
		System.out.println("Running " + getClass().getSimpleName());
	}

}
