package com_Adactin_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_Searchpage {
	public static WebDriver driver;
	
	//constructor
	public Adactin_Searchpage(WebDriver dr) {
		this.driver=dr;
		PageFactory.initElements(dr, this);
	}

	//identify
	@FindBy(xpath="//input[@id='datepick_in']")
	WebElement checkin;
	
	@FindBy(xpath="//input[@id='datepick_out']")
	WebElement checkout;
	
	//actions
	public void incheck(String indate) {
		checkin.sendKeys(indate);
	}
	
	public void outcheck(String outdate) {
		checkout.sendKeys(outdate);
	}
	
}
