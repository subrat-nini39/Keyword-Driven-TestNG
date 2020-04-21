package com.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public ChromeOptions options;
	
	public WebDriver ChromeLaunch(String browsername) {
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\workspace\\KeywordTestNG\\Drivers\\chromedriver_win32 (2)\\chromedriver.exe");
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
		}
		return driver;
	}
	public Properties GetProperties() {
		prop=new Properties();
		try {
			FileInputStream file=new FileInputStream("D:\\workspace\\KeywordTestNG\\src\\main\\java\\com\\sample\\automation\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
		
}
	
