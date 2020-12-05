package com.tests.TestAutomatahon2020Challenge.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;

import com.tests.TestAutomatahon2020Challenge.annotations.LazyConfiguration;
import com.tests.TestAutomatahon2020Challenge.scope.BrowserScopePostProcessor;

@LazyConfiguration
public class BrowserScopeConfig {

	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new BrowserScopePostProcessor();
	}
	
}
