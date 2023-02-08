package com.xworkz.bekary.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BekaryWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public BekaryWebInit() {
		System.out.println("Running BekaryWebInit");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running  getServletConfigClasses");
		return new Class[] { BekaryConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running getServletMappings ");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("runing configureDefaultServletHandling");
		configurer.enable();
	}

}
