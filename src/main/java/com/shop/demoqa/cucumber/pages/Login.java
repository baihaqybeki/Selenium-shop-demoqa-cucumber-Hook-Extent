package com.shop.demoqa.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.demoqa.cucumber.driver.DriverSingleton;

public class Login {
	
	private WebDriver driver;
	
	public Login() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//div[@id='primary']//li[1]")
	private WebElement errorMessage;
	
	@FindBy(xpath="//*[@id=\"post-8\"]/div/div/div/p[2]")
	private WebElement greetMessage;
	
	public void fillField(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public String validate(String isValid) {
		if (isValid.equalsIgnoreCase("valid")) {
			return greetMessage.getText();
		} else if (isValid.equalsIgnoreCase("invalid")) {
			return errorMessage.getText();
		}else {
			return null;
		}
	}
}
