package com.tests.TestAutomatahon2020Challenge.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Value;

import com.github.javafaker.Faker;
import com.tests.TestAutomatahon2020Challenge.annotations.LazyAutowired;
import com.tests.TestAutomatahon2020Challenge.pageobjects.automatahon.FormDetailsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestFormDetails {
	
	@LazyAutowired
	private FormDetailsPage formDetails;
	
	@LazyAutowired
	private Faker faker;
	
	@Value("${application.challenge3.url}")
	private String url;
	
	@Value("classpath:Dummyfile.txt")
	private String filePath;

	@Given("User is on Form Details Page")
	public void user_is_on_form_details_page() {
	    formDetails.goTo(url);
	    assertThat(formDetails.at());
	}
	
	@When("User enter all the details")
	public void user_enter_all_the_details() {
		formDetails.enterName(faker.name().firstName(), faker.name().lastName());
	    formDetails.enterEmail(faker.internet().emailAddress());
	    formDetails.enterMobileNo(faker.phoneNumber().phoneNumber());
	    formDetails.getAddress().setAddressLine1(faker.address().streetName());
	    formDetails.getAddress().setCity(faker.address().cityName());
	    formDetails.getAddress().setState(faker.address().state());
	    formDetails.getAddress().setCountry("India");
	    formDetails.getAddress().setPostalCode(faker.address().countryCode());
	    formDetails.getCalendarComponent().selectDay("10").selectMonth("March").selectYear("2005");
	    formDetails.currentWorking(false);
	    formDetails.fileUpload(filePath);
	}

	@When("User enter the details")
	public void user_enter_the_details() {
		formDetails.enterName(faker.name().firstName(), faker.name().lastName());
	    formDetails.enterMobileNo(faker.phoneNumber().phoneNumber());
	    formDetails.getAddress().setAddressLine1(faker.address().streetName());
	    formDetails.getAddress().setCity(faker.address().cityName());
	    formDetails.getAddress().setState(faker.address().state());
	    formDetails.getAddress().setCountry("India");
	    formDetails.getAddress().setPostalCode(faker.address().countryCode());
	    formDetails.getCalendarComponent().selectMonth("March").selectYear("2005").selectDay("10");
	    formDetails.currentWorking(false);
	    formDetails.fileUpload(filePath);
	}

	@Then("Form should be submitted successfully")
	public void form_should_be_submitted_successfully_with_message() {
	    formDetails.submit();
	}

	@When("leave mobileNo as blank")
	public void leave_mobile_no_as_blank() {
		formDetails.enterMobileNo("");
	}

	@Then("Form should not get submitted with a message {string}")
	public void form_should_not_get_submitted() {
		assertThat(formDetails.mandatoryFieldMissing()).isTrue();
	}

	@When("enter wrong emailId as {string}")
	public void enter_wrong_email_id(String emailid) {
	    formDetails.enterEmail(emailid);
	    
	}
}
