package com.tests.TestAutomatahon2020Challenge;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tests.TestAutomatahon2020Challenge.annotations.LazyAutowired;
import com.tests.TestAutomatahon2020Challenge.utils.ClickableElementLocatorFactoryService;

public class UIComponent {
	
	@LazyAutowired
	protected WebDriver driver;
	
	@LazyAutowired
	protected WebDriverWait wait;
	
	@LazyAutowired
	protected ClickableElementLocatorFactoryService elementLocatorFactory;
	
	@PostConstruct
	public void initElements() {
		PageFactory.initElements(elementLocatorFactory, this);
	}

}
