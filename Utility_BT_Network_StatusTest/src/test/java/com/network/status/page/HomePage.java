package com.network.status.page;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

	@AndroidFindBy(id = "button1")
	private WebElement btn1;
	@AndroidFindBy(id = "button2")
	private WebElement btn2;
	@AndroidFindBy(id = "result")
	private WebElement resultTxt;

	public HomePage(AppiumDriver driver) {
		super(driver);
	}

	public String getResultTxt() {
		return resultTxt.getText();
	}

	public void clickBtn1() {
		btn1.click();
	}

	public void clickBtn2() {
		btn2.click();
	}

}
