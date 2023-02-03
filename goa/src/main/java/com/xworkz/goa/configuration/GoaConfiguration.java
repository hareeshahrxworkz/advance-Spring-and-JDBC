package com.xworkz.goa.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.goa")
public class GoaConfiguration {

	public GoaConfiguration() {
		System.out.println("Running : " + getClass().getSimpleName());
	}

}
