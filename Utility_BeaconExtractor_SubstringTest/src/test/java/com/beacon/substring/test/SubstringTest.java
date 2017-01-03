package com.beacon.substring.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beacon.substring.page.HomePage;

public class SubstringTest extends TestBase {

	private HomePage homePage;

	@Override
	public String getName() {
		return "Beacon substring Test";
	}

	/**
	 * Sets up the home view page
	 */
	@BeforeTest
	@Override
	public void setUpPage() {
		homePage = new HomePage(driver);
	}

	@Test
	public void testSubstring() throws InterruptedException {
		homePage.clickBtn1();
		Assert.assertEquals(homePage.getResultTxt(), "f6ecbe56-5680-42b8-a809-71ad39cd92dc-1-6");
	}

}
