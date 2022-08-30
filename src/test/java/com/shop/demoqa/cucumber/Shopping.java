package com.shop.demoqa.cucumber;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.shop.demoqa.cucumber.driver.DriverSingleton;
import com.shop.demoqa.cucumber.pages.PlaceOrder;
import com.shop.demoqa.cucumber.pages.Search;
import com.shop.demoqa.cucumber.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Shopping {
	
	public static WebDriver driver;
	private Search search = new Search();
	private PlaceOrder placeOrder = new PlaceOrder();
	
	
	public Shopping() {
		driver = Hook.driver;
	}
	
	@When("^user navigate web page$")
	public void navigate() {
		driver.get(Constants.loginUrl);
	}
	
	@And("^search \"([^\"]*)\" item")
	public void search(String item) {
		search.searchItem(item);
	}
	
	@And("^add \"([^\"]*)\" item$")
	public void addFirstItem(String item) {
		placeOrder.detailProduct(item);
		placeOrder.checkOut();
	}
	
	@And("^user filling billing detail$")
	public void inputBillingDetail() {
		placeOrder.billingDetails();
		placeOrder.terms();
	}
	
	@And("^user place order$")
	public void placeOrder() {
		placeOrder.placeOrder();
	}
	
	@Then("^validate \"([^\"]*)\" scenario$")
	public void validate(String isValid) {
		if (isValid.equalsIgnoreCase(isValid)) {
			String actual = placeOrder.getSuccessMessage();
			assertTrue(actual.contains("Your order has been received"));
		}
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
