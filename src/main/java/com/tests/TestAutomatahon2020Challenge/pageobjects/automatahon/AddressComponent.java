package com.tests.TestAutomatahon2020Challenge.pageobjects.automatahon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.TestAutomatahon2020Challenge.annotations.PageComponent;

@PageComponent
public class AddressComponent extends UIComponent{
	
	@FindBy(how = How.CSS, using = "input.wpforms-field-address-address1")
	private WebElement addressLine1;

	@FindBy(how = How.CSS, using = "input.wpforms-field-address-city")
	private WebElement city;
	
	@FindBy(how = How.CSS, using = "input.wpforms-field-address-state")
	private WebElement state;
	
	@FindBy(how = How.CSS, using = "input.wpforms-field-address-postal")
	private WebElement postalCode;
	
	@FindBy(how = How.CSS, using = "select.wpforms-field-address-country")
	private WebElement country;
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1.sendKeys(addressLine1);
	}

	public void setCity(String city) {
		this.city.sendKeys(city);
	}

	public void setState(String state) {
		this.state.sendKeys(state);
	}

	public void setPostalCode(String postalCode) {
		this.postalCode.sendKeys(postalCode);
	}

	public void setCountry(String country) {
		selectDropDownValueByText(this.country, country);
	}

	@Override
	public boolean isDisplayed() {
		return wait.until(driver -> country.isDisplayed());
	}

}
