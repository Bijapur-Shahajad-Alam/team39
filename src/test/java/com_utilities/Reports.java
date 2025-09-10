package com_utilities;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com_Adactin_testcases.Adactin_Baseclass;

public class Reports implements ITestListener {

	public ExtentSparkReporter report;
	//It provides the basic information of the document (Report Name, Document Title,Theme of the Report)
	public ExtentReports extent;
	//It provides the basic info of the User (User name, Host name, OS, Browser, Environment)
	public ExtentTest test;
	//It provides the basic info about the Test Cases--> Pass/fail/skipped


	//Pre-defined Methods:onStart, onTestSuccess, onTestFailure, onTestSkipped, onFinish 


	// from ITestListener: for passing info:ITestContext ,for getting output:ITestResult


	public void onStart(ITestContext tr) {
		//provided info about the Document	

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String name = "AdactinLogin"+timeStamp+"Report1.html";

		report = new ExtentSparkReporter("./TestReports/"+name);
		//report = new ExtentSparkReporter("D:\\Alam\\eclipse\\selenium39hybrid\\TestReports\\"+name);
		report.config().setDocumentTitle("Login report");
		report.config().setTheme(Theme.DARK);

		//provided info about the User	

		extent= new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("UserName", "Alam");
		extent.setSystemInfo("Sprint", "1");
		extent.setSystemInfo("HostName", "Local host");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA"); 
	}

	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		try {
			String screenshot = new Adactin_Baseclass().CaptureScreenShots(tr.getName());
			test.addScreenCaptureFromPath(screenshot);
		} catch (IOException e) { 
		
			e.printStackTrace();
		} 

	}
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		try {
			String screenshot = new Adactin_Baseclass().CaptureScreenShots(tr.getName());
			test.addScreenCaptureFromPath(screenshot);
		} catch (IOException e) { 
		
			e.printStackTrace();
		} 

       
	}
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.BLUE));
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		// removing unnecessary data
	}


}

