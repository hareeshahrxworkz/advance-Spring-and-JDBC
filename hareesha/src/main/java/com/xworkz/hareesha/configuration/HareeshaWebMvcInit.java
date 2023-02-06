package com.xworkz.hareesha.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HareeshaWebMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {
	public HareeshaWebMvcInit() {
		System.out.println("Running HareeshaWebMvcInit");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running getServletConfigClasses");
		return new Class[] { HareeshaConfuguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings");

		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

		configurer.enable();
	}

}
