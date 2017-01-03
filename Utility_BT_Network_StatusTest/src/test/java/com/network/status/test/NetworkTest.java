package com.network.status.test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.network.status.utils.SettingsUtils;

import io.appium.java_client.NetworkConnectionSetting;

public class NetworkTest extends TestBase {
	// private HomePage homePage;
	private NetworkConnectionSetting networkCon;
	private static SettingsUtils sUtil;

	private final String TOGGLE_ACTIVATED_TEXT = "ON";
	private final String TOGGLE_INACTIVATED_TEXT = "OFF";

	@Override
	public String getName() {
		return "Network Test";
	}

	/**
	 * Sets up the home view page
	 */
	@BeforeTest
	@Override
	public void setUpPage() {
		// homePage = new HomePage(driver);
		networkCon = driver.getNetworkConnection();
		sUtil = new SettingsUtils();
	}

	/**
	 * Wifi or data is
	 */
	@Test
	public void testWifiAndData() {
		Assert.assertTrue(networkCon.wifiEnabled() || networkCon.dataEnabled());
	}

	@Test
	public void testBluetoothConnectionOn() throws InterruptedException {
		WebElement bt = sUtil.findSingleElInPage(driver, "Bluetooth", "android.widget.Switch");

		takeScreenshot("Before click On");
		// Turn on bluetooth if it is off
		if (!bt.getText().equalsIgnoreCase(TOGGLE_ACTIVATED_TEXT)) {
			bt.click();
		}
		Thread.sleep(5000);
		takeScreenshot("After click ON");
		Assert.assertEquals(bt.getText(), TOGGLE_ACTIVATED_TEXT);

	}

	@Test(dependsOnMethods = { "testBluetoothConnectionOn" })
	public void testBluetoothConnectionOff() throws InterruptedException {
		WebElement bt = sUtil.findSingleElInPage(driver, "Bluetooth", "android.widget.Switch");

		takeScreenshot("Before click Off");
		// Turn on bluetooth if it is off
		if (bt.getText().equalsIgnoreCase(TOGGLE_ACTIVATED_TEXT)) {
			bt.click();
		}
		Thread.sleep(5000);
		takeScreenshot("After click OFF");
		Assert.assertEquals(bt.getText(), TOGGLE_INACTIVATED_TEXT);
	}

	/**
	 * Take screenshot of the current device
	 * 
	 * @param name
	 *            - File name to be saved
	 * @return
	 */
	public boolean takeScreenshot(final String name) {
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}
}
