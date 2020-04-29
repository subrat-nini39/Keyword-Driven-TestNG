package ExtentReport;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtentReport {
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void StartReport() {
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/MyOwnReport.html");
		extent.addSystemInfo("Host Name", "LocalHost");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("User Name", "Subrat");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@Test
	public void PassReport() {
		test=extent.startTest("PassReport");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert Pass as condition is true");
	}
	@Test
	public void FailReport() {
		test=extent.startTest("FailReport");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "Assert Fail as condition is false");
	}
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		extent.endTest(test);
		}
	@AfterTest
	public void EndReport() {
		extent.flush();
	}	
}
