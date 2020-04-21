package com.keyword.run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.keyword.base.Base;

public class Run {
	public WebDriver driver;
	public Properties prop;
	public static Workbook book;
	public static Sheet sheet;
	
	public Base base;
	public WebElement ele;
	
	public final String sPath="D:\\workspace\\KeywordTestNG\\DataSheet\\AndhraHomeLoan.xlsx";
	
	public void Start(String SheetName) {
		String locName=null;
		String locValue=null;
		FileInputStream file=null;
		try {
			file=new FileInputStream(sPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(SheetName);
		int k=0;
		for(int i=0;i<sheet.getLastRowNum();i++) {
			try {
			String locColValue=sheet.getRow(i+1).getCell(k+1).toString().trim();
			if(!locColValue.equalsIgnoreCase("NA")) {
				locName=locColValue.split("=")[0].trim();
				locValue=locColValue.split("=")[1].trim();
			}
			String action=sheet.getRow(i+1).getCell(k+2).toString().trim();
			String value=sheet.getRow(i+1).getCell(k+3).toString().trim();
			
			switch (action) {
			case "open browser":
				base=new Base();
				prop=base.GetProperties();
				if(value.isEmpty() || value.equals("NA")) {
					driver=base.ChromeLaunch(prop.getProperty("browser"));
				}else {
					driver=base.ChromeLaunch(value);
				}
				
				break;
			case "enter url":
				if(value.isEmpty() || value.equals("NA")) {
					driver.get(prop.getProperty("url"));
				}else {
					driver.get(value);
				}
				System.out.println(value);
				break;
			case "quit":
				driver.quit();
				break;

			default:
				break;
			}
			switch (locName) {
			case "id":
				ele=driver.findElement(By.id(locValue));
				if(action.equalsIgnoreCase("sendkeys")) {
					ele.clear();
					ele.sendKeys(value);
				}else if(action.equalsIgnoreCase("click")) {
					ele.click();
				}
				locName=null;
				break;
				
			case "linkTest":
				ele=driver.findElement(By.id(locValue));
				ele.click();
				locName=null;
				break;
			case "xpath":
				ele=driver.findElement(By.id(locValue));
				ele.click();

			default:
				break;
			}
			}
			catch(Exception e) {
				
			}
		}

	}
		
}
	
