package com.tests.TestAutomatahon2020Challenge.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Bean
@Scope("browserscope")
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface BeanWithBrowserScope {

}
