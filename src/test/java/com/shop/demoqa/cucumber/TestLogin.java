package com.shop.demoqa.cucumber;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.shop.demoqa.cucumber.driver.DriverSingleton;
import com.shop.demoqa.cucumber.pages.Login;
import com.shop.demoqa.cucumber.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogin {
	
	public static WebDriver driver;
	private Login login;
	
	@Before
	public void setup() {
		DriverSingleton.getInstance(Constants.Chrome);
		login = new Login();
		
	}
	
	@Given("^user navigate to login page$")
	public void navigate_login() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.loginUrl);
	}
	
	@When("^user enter \"([^\"]*)\" as username & \"([^\"]*)\" as password$")
	public void seacrh(String username,String password) {
		login.fillField(username,password);
	}
	
	@And("^user click button login$")
	public void clickLogin() {
		login.clickLogin();
	}
	
	@Then("^validate page with \"([^\"]*)\" scenario$")
	public void validate(String isValid) {
		if (isValid.equalsIgnoreCase("valid")) {
			String actual = login.validate(isValid);
			assertTrue(actual.contains("your account"));
		}else if(isValid.equalsIgnoreCase("invalid")) {
			String actual = login.validate(isValid);
			assertTrue(actual.contains("is incorrect"));
		}
	}
	
	@After
	public void closeBrowser() {
		delay(1);
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
