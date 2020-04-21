package com.keyword.TestNG;

import org.testng.annotations.Test;

import com.keyword.run.Run;

public class TestNG {
	
	public Run run;
	@Test
	public void AndhraBank() {
		run=new Run();
		run.Start("Sheet1");
	}
}
