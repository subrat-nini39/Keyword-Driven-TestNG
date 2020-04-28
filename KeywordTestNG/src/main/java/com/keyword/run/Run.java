package com.keyword.run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.lang.model.element.ElementVisitor;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.keyword.base.Base;

public class Run {
	public WebDriver driver;
	public Properties prop;
	public static Workbook book;
	public static Sheet sheet;
	public static String currwindow;
	
	public Base base;
	public WebElement ele;
	
	public WebDriverWait wait;
	public static int maxwait=90;
	
	public final String sPath="D:\\workspace\\Keyword-Driven-TestNG-Git\\KeywordTestNG\\DataSheet\\AndhraHomeLoan.xlsx";
	
	public void Start(String SheetName) {
		/*
		 * String locName=null; String locValue=null;
		 */
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
			String locColType=sheet.getRow(i+1).getCell(k+1).toString().trim();
			String locColValue=sheet.getRow(i+1).getCell(k+2).toString().trim();

			String action=sheet.getRow(i+1).getCell(k+3).toString().trim();
			String value=sheet.getRow(i+1).getCell(k+4).toString().trim();
			
			switch (action) {
			case "open browser":
				base=new Base();
				prop=base.GetProperties();
				if(value.isEmpty() || value.equals("NA")) {
					driver=base.BrowserLaunch(prop.getProperty("browser"));
				}else {
					driver=base.BrowserLaunch(value);
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
				
			case "wait":
				Thread.sleep(5000);
				break;
				
			case "currentwindow":
				currwindow=driver.getWindowHandle();
				break;
				
			case "switchwindow":
				String urlwin=currwindow;
				Set<String> chilwin=driver.getWindowHandles();
				System.out.println("Total Window "+chilwin.size());			

				System.out.println("driver is " +urlwin);
				for( String currentwin:chilwin)
				{
					if (!currentwin.equalsIgnoreCase(urlwin))
					{
						System.out.println(urlwin +"\n"+currentwin);
						driver.switchTo().window(currentwin);
						String urlwin1=driver.getWindowHandle();
						Thread.sleep(3000);
						System.out.println("driver is on " +urlwin1);
						System.out.println("Current window Title is ---->  "+driver.getTitle());
					}
				}
				break;
				
			default:
				break;
			}
			switch (locColType) {
			case "id":
				ele=driver.findElement(By.id(locColValue));
				if(action.equalsIgnoreCase("sendkeys")) {
					ele.clear();
					ele.sendKeys(value);
				}else if(action.equalsIgnoreCase("click")) {
					ele.click();
				}else if(action.equalsIgnoreCase("isDisplayed")) {
					ele.isDisplayed();
				}else if(action.equalsIgnoreCase("getText")) {
					String eleText=ele.getText();
					System.out.println(eleText);
				}
				locColType=null;
				break;
				
			case "name":
				ele=driver.findElement(By.name(locColValue));
				if(action.equalsIgnoreCase("sendkeys")) {
					ele.clear();
					ele.sendKeys(value);
				}else if(action.equalsIgnoreCase("click")) {
					ele.click();
				}else if(action.equalsIgnoreCase("isDisplayed")) {
					ele.isDisplayed();
				}else if(action.equalsIgnoreCase("getText")) {
					String eleText=ele.getText();
					System.out.println(eleText);
				}
				locColType=null;
				break;
				
			case "cssSelector":
				ele=driver.findElement(By.cssSelector(locColValue));
				if(action.equalsIgnoreCase("sendkeys")) {
					ele.clear();
					ele.sendKeys(value);
				}else if(action.equalsIgnoreCase("click")) {
					ele.click();
				}else if(action.equalsIgnoreCase("isDisplayed")) {
					ele.isDisplayed();
				}else if(action.equalsIgnoreCase("getText")) {
					String eleText=ele.getText();
					System.out.println(eleText);
				}
				locColType=null;
				break;
				
			case "linkTest":
				ele=driver.findElement(By.linkText(locColValue));
				ele.click();
				locColType=null;
				break;
				
			case "partialLinkTest":
				ele=driver.findElement(By.partialLinkText(locColValue));
				ele.click();
				locColType=null;
				break;
				
			case "xpath":
				ele=driver.findElement(By.xpath(locColValue));
				if(action.equalsIgnoreCase("sendkeys")) {
					ele.clear();
					ele.sendKeys(value);
				}else if(action.equalsIgnoreCase("click")) {
					ele.click();
				}else if(action.equalsIgnoreCase("isDisplayed")) {
					ele.isDisplayed();
				}else if(action.equalsIgnoreCase("getText")) {
					String eleText=ele.getText();
					System.out.println(eleText);
				}
				locColType=null;
				break;
				
			case "className":
				ele=driver.findElement(By.className(locColValue));
				if(action.equalsIgnoreCase("sendkeys")) {
					ele.clear();
					ele.sendKeys(value);
				}else if(action.equalsIgnoreCase("click")) {
					ele.click();
				}else if(action.equalsIgnoreCase("isDisplayed")) {
					ele.isDisplayed();
				}else if(action.equalsIgnoreCase("getText")) {
					String eleText=ele.getText();
					System.out.println(eleText);
				}
				locColType=null;
				break;
				
			default:
				break;
			}
			}
			catch(Exception e) {
				
			}
		}

	}
		
}
	
