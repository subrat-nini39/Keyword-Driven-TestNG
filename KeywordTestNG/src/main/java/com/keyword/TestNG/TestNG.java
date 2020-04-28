package com.keyword.TestNG;

import org.testng.annotations.Test;

import com.keyword.run.Run;

public class TestNG {
	
	public Run run;
	@Test(priority = 1, enabled=false)
	public void AndhraBankLoan() {
		run=new Run();
		run.Start("Sheet1");
	}
	@Test(priority = 2)
	public void AndhraBankCustomerCorner() {
		run=new Run();
		run.Start("Sheet2");
	}
	@Test(priority = 3)
	public void AndhraBankSecurityTips() {
		run=new Run();
		run.Start("Sheet3");
	}
}
