package com.alarm.service.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alarm.service.page.HomePage;

public class AlarmServiceTest extends TestBase {

	private HomePage homePage;

	@Override
	public String getName() {
		return "Alarm Service Test";
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
	public void testAlarmService() throws InterruptedException {
		homePage.clickBtn1();
		Thread.sleep(5000);
		System.currentTimeMillis();
		Assert.assertTrue(Integer.parseInt(homePage.getResultTxt()) < 100);
	}

}
