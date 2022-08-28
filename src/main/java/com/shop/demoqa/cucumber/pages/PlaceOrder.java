package com.shop.demoqa.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shop.demoqa.cucumber.driver.DriverSingleton;

public class PlaceOrder {
	
	private WebDriver driver;
	
	public PlaceOrder() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[normalize-space()='pink drop shoulder oversized t shirt']")
	private static WebElement pinkProductClick;
	
	@FindBy(xpath = "//a[normalize-space()='white milkmaid hook and eye bodycon midi dress']")
	private static WebElement dressProductClick;
	
	
//	@FindBy(id = "pa_color")
//	private Select dropdownColor ;
//	
//	@FindBy(id = "pa_size")
//	private Select dropdownSize;
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	private WebElement btnAddCart;
	
	@FindBy(xpath = "//i[@class='icon_bag_alt']")
	private WebElement cartBtn;
	
	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	private WebElement checkoutBtn;
	
	@FindBy(id="billing_first_name")
	private WebElement firstName;
	
	@FindBy(id= "billing_last_name")
	private WebElement lastName;
	
	@FindBy(xpath = "//span[@aria-label='Country / Region']//span[@role='presentation']")
	private WebElement dropdownCountry;
	
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement inputCountry;
	
	
	@FindBy(id="billing_address_1")
	private WebElement address;
	
	@FindBy(id="billing_city")
	private WebElement city;
	
	@FindBy(xpath="//span[@aria-label='Province']//span[@role='presentation']")
	private WebElement dropdownProvince;
	
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement inputProvince;
	
	@FindBy(id="billing_postcode")
	private WebElement zip;
	
	@FindBy(id="billing_phone")
	private WebElement phone;
	
	@FindBy(id="billing_email")
	private WebElement email;
	
	@FindBy(xpath="//*[@id=\"terms\"]")
	private WebElement terms;
	
	@FindBy(xpath="//button[@id='place_order']")
	private WebElement placeorderBtn;
	
	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//li[contains(text(),'Please read and accept the terms and conditions to')]")
	private WebElement errorTermMessage;
	
	@FindBy(xpath = "//li[@data-id='billing_first_name']")
	private WebElement errorBillingMessage;
	
	public void detailProduct(String item) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		whichProduct(item);
		Select dropdownColor = new Select(driver.findElement(By.id("pa_color")));
		Select dropdownSize = new Select(driver.findElement(By.id("pa_size")));
		js.executeScript("window.scrollBy(0,650)");
		dropdownColor.selectByIndex(1);
		dropdownSize.selectByIndex(1);
		delay(3);
		btnAddCart.click();
	}
	
	public void checkOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		cartBtn.click();
		js.executeScript("window.scrollBy(0,650)");
		checkoutBtn.click();
	}
	
	public void billingDetails() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.firstName.sendKeys("testing");
		this.lastName.sendKeys("98");
		js.executeScript("window.scrollBy(0,650)");
		dropdownCountry.click();
		this.inputCountry.sendKeys("Indonesia",Keys.ENTER);
		this.address.sendKeys("Jakarta");
		this.city.sendKeys("Jakarta Barat");
		dropdownProvince.click();
		this.inputProvince.sendKeys("Dki Jakarta",Keys.ENTER);
		this.zip.sendKeys("14701");
		this.phone.sendKeys("080989999");
		this.email.sendKeys("testing98@mail.com");
	}
	
	public void terms() {
		delay(3);
		terms.click();
	}
	
	public void placeOrder() {
		placeorderBtn.click();
	}
	
	public String getSuccessMessage() {
		return successMessage.getText();
	}
	
	public String getErrorTermMessage() {
		return errorTermMessage.getText();
	}
	
	public String getErrorBillingMessage() {
		return errorBillingMessage.getText();
	}
	
	static void whichProduct(String item) {
		if (item.equalsIgnoreCase("pink")) {
			pinkProductClick.click();
		}else if(item.equalsIgnoreCase("dress")) {
			dressProductClick.click();
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
