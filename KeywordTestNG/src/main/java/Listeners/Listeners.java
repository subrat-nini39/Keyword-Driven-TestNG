package Listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {
	
	public void ontestStart(ITestResult tr) {
		System.out.println("Test Started");
	}
	public void ontestSuccess(ITestResult tr) {
		System.out.println("Test Success");
	}
	public void ontestFailure(ITestResult tr) {
		System.out.println("Test Failed");
	}
	public void ontestSkipped(ITestResult tr) {
		System.out.println("Test Skipped");
	}
	

}
