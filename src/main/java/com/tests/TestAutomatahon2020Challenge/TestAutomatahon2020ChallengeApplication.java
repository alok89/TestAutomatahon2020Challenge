package com.tests.TestAutomatahon2020Challenge;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestAutomatahon2020ChallengeApplication {

	public static void main(String[] args) {
		System.out.println("Starting Application.........");
		ApplicationContext context = SpringApplication.run(TestAutomatahon2020ChallengeApplication.class, args);
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(System.out::println);
	}

}
