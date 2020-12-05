package com.tests.TestAutomatahon2020Challenge.pageobjects.automatahon;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.TestAutomatahon2020Challenge.annotations.PageComponent;

@PageComponent
public class AutomatahonJuryComponent {

	@FindBy(how = How.CSS, using = "div[data-widget_type='eael-flip-box.default'] img.eael-flipbox-image-as-icon")
	private List<WebElement> membersImage;

	@FindBy(how = How.CSS, using = "div[data-widget_type='eael-flip-box.default'] h2.eael-elements-flip-box-heading")
	private List<WebElement> membersName;
	
	public List<String> getAllMembersImageDetails() {
		return membersImage.stream().map(element -> element.getAttribute("src")).collect(Collectors.toList());
	}
	
	public List<String> getAllMembersNameDetails() {
		return membersName.stream().map(element -> element.getText()).collect(Collectors.toList());
	}
}
