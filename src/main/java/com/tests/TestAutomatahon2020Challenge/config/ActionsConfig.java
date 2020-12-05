
package com.tests.TestAutomatahon2020Challenge.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.tests.TestAutomatahon2020Challenge.annotations.BeanWithPrototypeScope;
import com.tests.TestAutomatahon2020Challenge.annotations.LazyConfiguration;

@LazyConfiguration
public class ActionsConfig {

	@BeanWithPrototypeScope
	public Actions actions(WebDriver driver) {
		return new Actions(driver);
	}

}
