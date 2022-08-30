package com.shop.demoqa.cucumber;

import org.openqa.selenium.WebDriver;

import com.shop.demoqa.cucumber.driver.DriverSingleton;
import com.shop.demoqa.cucumber.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hook {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		DriverSingleton.getInstance(Constants.Chrome);
		driver = DriverSingleton.getDriver();
	}
	
	@After
	public static void closeBrowser() {
		delay(3);
		DriverSingleton.closeObjectInstance();
	} 
	
	static void delay(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
