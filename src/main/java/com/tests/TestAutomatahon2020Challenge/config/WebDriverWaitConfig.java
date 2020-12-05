package com.tests.TestAutomatahon2020Challenge.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import com.tests.TestAutomatahon2020Challenge.annotations.BeanWithPrototypeScope;
import com.tests.TestAutomatahon2020Challenge.annotations.LazyConfiguration;

@LazyConfiguration
public class WebDriverWaitConfig {

	@Value("${webDriverWait.timeout:15}")
	private int timeOut;

	@BeanWithPrototypeScope
	public WebDriverWait webDriverWait(WebDriver driver) {
		return new WebDriverWait(driver, timeOut);
	}
}
