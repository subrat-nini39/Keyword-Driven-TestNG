package com.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public ChromeOptions options;
	
	
	public WebDriver BrowserLaunch(String browsername) {
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\workspace\\Keyword-Driven-TestNG-Git\\KeywordTestNG\\Drivers\\chromedriver_win32 (2)\\chromedriver.exe");
			if(prop.getProperty("headless").equals("yes")) {
				// Headless Mode
				options=new ChromeOptions();
				options.addArguments("--headless");
				driver=new ChromeDriver(options);
				driver.manage().window().maximize();
			}else {
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
			
		}else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\workspace\\Keyword-Driven-TestNG-Git\\KeywordTestNG\\Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(browsername.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\workspace\\Keyword-Driven-TestNG-Git\\KeywordTestNG\\Drivers\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	public Properties GetProperties() {
		prop=new Properties();
		try {
			FileInputStream file=new FileInputStream("D:\\workspace\\Keyword-Driven-TestNG-Git\\KeywordTestNG\\src\\main\\java\\com\\sample\\automation\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
		
}
	
