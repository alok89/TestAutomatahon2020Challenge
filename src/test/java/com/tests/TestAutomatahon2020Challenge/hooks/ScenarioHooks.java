package com.tests.TestAutomatahon2020Challenge.hooks;

import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.tests.TestAutomatahon2020Challenge.annotations.LazyAutowired;
import com.tests.TestAutomatahon2020Challenge.utils.ScreenshotService;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ScenarioHooks {
	
	@Autowired
	private WebDriver driver;

	@Value("${screenshot.path}")
	private Path path;
	
	@LazyAutowired
	private ScreenshotService screenshotService;

	@Before(order = 0)
	public void beforeScenario(Scenario scenario) {
		String scenarioName = scenario.getName();
		System.out.println("Scenario SetUp : "+getFeatureName(scenario)+" > "+scenarioName);
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		String scenarioName = scenario.getName();
		scenario.attach(screenshotService.getScreenshotAsBytes(), "image/png", scenarioName);
		driver.quit();
	}

	private String getFeatureName(Scenario scenario) {
		String id = scenario.getId();
		String featureFileName = id.substring((id.indexOf('/')+1), id.lastIndexOf(':'));
		return featureFileName;
	}

}
