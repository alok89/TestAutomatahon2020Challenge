package com.tests.TestAutomatahon2020Challenge.pageobjects.automatahon;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tests.TestAutomatahon2020Challenge.annotations.PageComponent;

@PageComponent
public class CalendarComponent extends UIComponent {
	
	
	@FindBy(how = How.CSS, using = "input.wpforms-field-date-time-date")
	private WebElement dob;
	
	@FindBy(how = How.CSS, using = "div.flatpickr-calendar")
	private WebElement calender;
	
	@FindBy(how = How.CLASS_NAME, using = "flatpickr-monthDropdown-months")
	private WebElement months;
	
	@FindBy(how = How.CSS, using = "input.numInput")
	private WebElement year;
	
	@FindBy(how = How.CSS, using = "span[class='flatpickr-day ']")
	private List<WebElement> days;
	
	public boolean isDisplayed() {
		return calender.isDisplayed();
	}
	
	public CalendarComponent selectMonth(String monthName) {
		selectDropDownValueByText(months, monthName);
		return this;
	}
	
	public CalendarComponent selectYear(String year) {
		this.year.clear();
		this.year.sendKeys(year);
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		return this;
	}
	
	public CalendarComponent selectDay(String day) {
		WebElement dayElement = days.stream().filter(element -> element.getText().trim().equals(day)).findFirst().get();
		dayElement.click();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		return this;
	}
}
