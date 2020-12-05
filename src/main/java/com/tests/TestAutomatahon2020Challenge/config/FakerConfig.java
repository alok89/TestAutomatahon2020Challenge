package com.tests.TestAutomatahon2020Challenge.config;

import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.tests.TestAutomatahon2020Challenge.annotations.LazyConfiguration;

@LazyConfiguration
public class FakerConfig {

	@Bean
	public Faker faker() {
		return new Faker();
	}
}
