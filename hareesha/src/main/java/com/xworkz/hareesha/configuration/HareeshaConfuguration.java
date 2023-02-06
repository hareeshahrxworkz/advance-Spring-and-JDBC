package com.xworkz.hareesha.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.hareesha")
public class HareeshaConfuguration {
	public HareeshaConfuguration() {
		System.out.println("Running HareeshaConfuguration");
	}

}