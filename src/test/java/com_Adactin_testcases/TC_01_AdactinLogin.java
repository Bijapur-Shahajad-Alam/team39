package com_Adactin_testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com_Adactin_pageobjects.Adactin_Loginpage;

public class TC_01_AdactinLogin extends Adactin_Baseclass{
public Adactin_Loginpage page;


@Test
public void loginadactin() throws InterruptedException {
	// object creation
	// classname variablename = new classname();
	page = new Adactin_Loginpage(driver);
		
	page.textusername(rb.getString("uname"));
	//System.out.println("username entered successfully");
	log.info("username entered successfully");
	
	Thread.sleep(1000);
	page.textpassword(rb.getString("pword"));
	//System.out.println("password entered successfully");
	log.info("password entered successfully");
	Thread.sleep(1000);
	page.clicklogin();
	//System.out.println("login clicked successfully");
	log.info("login clicked successfully");
	
	String exp_title= "Adactin.com - Search Hotel";
	String act_title= driver.getTitle();
	
	if(act_title.equals(exp_title)) {
		Assert.assertTrue(true);
		System.out.println("Login successfull into Adactin");
	}else {
		System.out.println("Failed!!!!!!!!!!!!!!!!!!!!!!");
		Assert.assertTrue(false);
		
	}
	
}

	
	
	
	
	
	
	
	
	
}
