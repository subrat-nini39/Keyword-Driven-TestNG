package com.keyword.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.keyword.run.Run;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import Listeners.Listeners;

public class TestNG extends Listeners{

	ExtentReports extent;
	ExtentTest test;

	/*
	 * @BeforeTest public void StartReport() { extent=new
	 * ExtentReports(System.getProperty("user.dir")+"/test-output/AndhraBank.html");
	 * extent.addSystemInfo("Host Name", "LocalHost");
	 * extent.addSystemInfo("Environment", "QA"); extent.addSystemInfo("User Name",
	 * "Subrat"); extent.loadConfig(new
	 * File(System.getProperty("user.dir")+"\\extent-config.xml")); }
	 */

	public Run run;
	@Test(priority = 1)
	public void AndhraBankLoan() {
		//test=extent.startTest("AndhraBankLoan");
		run=new Run();
		run.Start("Sheet1");
		//test.log(LogStatus.PASS, "AndhraBankLoan");
	}

	@Test(priority = 3)
	public void AndhraBankCustomerCorner() {
		//test=extent.startTest("AndhraBankCustomerCorner");
		run=new Run();
		run.Start("Sheet2");
		//test.log(LogStatus.PASS, "AndhraBankCustomerCorner");
	}

	@Test(priority = 2)
	public void FailedTest() {
		Assert.fail();
		//test=extent.startTest("AndhraBankSecurityTips");
		/*
		 * run=new Run(); run.Start("Sheet3");
		 */
		//test.log(LogStatus.PASS, "AndhraBankSecurityTips");
	}

	/*
	 * @AfterMethod public void getResult(ITestResult result) {
	 * if(result.getStatus()==ITestResult.SUCCESS) { test.log(LogStatus.PASS,
	 * result.getThrowable()); } extent.endTest(test); }
	 * 
	 * @AfterTest public void EndReport() { extent.flush(); }
	 */
}
