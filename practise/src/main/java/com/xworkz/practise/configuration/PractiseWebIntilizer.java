package com.xworkz.practise.configuration;

import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PractiseWebIntilizer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	public PractiseWebIntilizer() {
		System.out.println("Running  practiseWebIntilizer");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		System.out.println("Running getServletConfigClasses ");
		return new Class[] { PractiseConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running getServletMappings");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running configureDefaultServletHandling");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
	}
}
