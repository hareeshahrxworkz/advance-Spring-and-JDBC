package com.xworkz.email.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EmailApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	public EmailApplicationInit() {
		System.out.println("Running" + getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running getServletConfigClasses ");
		return new Class[] { EmailApplicationConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running getServletMappings ");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Rinning configureDefaultServletHandling");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
	}

}
