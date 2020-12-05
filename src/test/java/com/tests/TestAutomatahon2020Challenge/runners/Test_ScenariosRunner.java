package com.tests.TestAutomatahon2020Challenge.runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@Test
@CucumberOptions (
		features = "classpath:features",
		glue = "com.tests.TestAutomatahon2020Challenge",
		tags = "@mystore",
		monochrome = true,
		plugin = {"pretty", 
				  "json:reports/cucumber.json",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "summary"}, 
		snippets = SnippetType.CAMELCASE )
public class Test_ScenariosRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
}
