package com_Adactin_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_Loginpage {
	public static WebDriver driver; // remote driver


	// constructor
	public Adactin_Loginpage(WebDriver dr) { //local driver
		this.driver = dr;
		PageFactory.initElements(dr, this);
	}
	//identify elements
	@FindBy(id="username")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="login")
	WebElement loginbutton;

	// create actions
	public void textusername(String name) {
		username.sendKeys(name);
	}
	public void textpassword(String pword) {
		password.sendKeys(pword);
	}
	public void clicklogin() {
		loginbutton.click();
	}
}
