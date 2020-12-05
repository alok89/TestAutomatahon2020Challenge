package com.tests.TestAutomatahon2020Challenge.pageobjects.automatahon;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tests.TestAutomatahon2020Challenge.annotations.LazyAutowired;
import com.tests.TestAutomatahon2020Challenge.utils.ClickableElementLocatorFactoryService;

public abstract class UIComponent {
	
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
	
	public abstract boolean isDisplayed();
	
	public void selectDropDownValueByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
	}

}
