package com_Adactin_testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Adactin_Baseclass {
	
	public static  WebDriver driver;
	public ResourceBundle rb;
	public Logger log;
	@BeforeSuite
	public void openApplication() {
		
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		rb = ResourceBundle.getBundle("Data");
		log=Logger.getLogger("selenium39hybrid");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public String CaptureScreenShots(String tname)throws IOException{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot sc = (TakesScreenshot)driver;
		File Source = sc.getScreenshotAs(OutputType.FILE);
		String Target = "./screenshots/"+tname+timeStamp+".png";
		//String Target = System.getProperty("user.dir")+"\\screenshots\\"+tname+timeStamp+".png";
		
		try {
			FileUtils.copyFile(Source, new File(Target));
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		return Target;
		
	}
	
	@AfterSuite
	public void closeApplication() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	} 
	
	}
	
	
	
	
	
	


