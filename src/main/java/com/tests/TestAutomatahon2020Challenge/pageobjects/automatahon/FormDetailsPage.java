package com.tests.TestAutomatahon2020Challenge.pageobjects.automatahon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.TestAutomatahon2020Challenge.annotations.LazyAutowired;
import com.tests.TestAutomatahon2020Challenge.annotations.Page;
import com.tests.TestAutomatahon2020Challenge.pageobjects.BasePage;

@Page
public class FormDetailsPage extends BasePage {
	
	private static final String PAGE_TITLE = "Challenge 3 – #AutomATAhon2020: Hackathon for testers";
	
	@FindBy(how = How.CSS, using = "div.dialog-close-button")
	private WebElement closeIcon;

	@FindBy(how = How.CSS, using = "input[placeholder='First Name ']")
	private WebElement firstName;
	
	@FindBy(how = How.CSS, using = "input[placeholder='Last Name ']")
	private WebElement lastName;
	
	@FindBy(how = How.CSS, using = "input[type='email']")
	private WebElement email;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class, 'wpforms-field-text')]/input)[1]")
	private WebElement mobile;
	
	@FindBy(how = How.CSS, using = "li.choice-1>input[type='radio']")
	private WebElement workingYes;
	
	@FindBy(how = How.CSS, using = "li.choice-2>input[type='radio']")
	private WebElement workingNo;
	
	@FindBy(how = How.CSS, using = "div.wpforms-field-file-upload span.modern-title")
	private WebElement fileUpload;
	
	@FindBy(how = How.CSS, using = "button.wpforms-submit ")
	private WebElement submit;
	
	@FindBy(how = How.XPATH, using = "//*[text()='This field is required.']")
	private WebElement fieldRequired;
	
	@FindBy(how = How.CSS, using = "input.wpforms-field-date-time-date")
	private WebElement dob;
	
	@LazyAutowired
	private AddressComponent addressComponent;
	
	@LazyAutowired
	private CalendarComponent calendarComponent;
	
	public void enterName(String fName, String lName) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
	}
	
	public void enterMobileNo(String number) {
		mobile.sendKeys(number);
	}
	
	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	
	public AddressComponent getAddress() {
		return addressComponent;
	}
	
	public CalendarComponent getCalendarComponent()  {
		dob.click();
		return calendarComponent;
	}
	
	public void currentWorking(boolean working) {
		if(working) {
			workingYes.click();
		}else {
			workingNo.click();
		}
	}
	
	public void fileUpload(String filePath) {
		fileUpload.sendKeys(filePath);
	}
	
	public void submit() {
		this.submit.click();
	}

	@Override
	public boolean at() {
		wait.until(driver -> closeIcon.isDisplayed());
		closeIcon.click();
		return driver.getTitle().equals(PAGE_TITLE);
	}
	
	public boolean mandatoryFieldMissing() {
		return fieldRequired.isDisplayed();
	}
}
