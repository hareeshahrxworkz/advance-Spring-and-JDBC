package com.xworkz.goa.configuration;

import java.util.Arrays;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class GoaWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running : getRootConfigClasses ");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running getServletConfigClasses");
		Class[] class1 = { GoaConfiguration.class };
		System.out.println("Creating " + Arrays.toString(class1));
		return class1;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running getServletConfigClasses ");
		String[] ref = { "/" };
		System.out.println("Creating  : " + Arrays.toString(ref));
		return ref;
	}

}
