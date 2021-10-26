package com.qa.guru99.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver ;
	public  static Properties prop;
	public static String  url;
	public static String url2;
	
	public TestBase() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("E:\\Java_Selenium\\Guru99Project\\src\\main\\java\\com\\qa\\guru99\\config\\config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		url=  prop.getProperty("url");
		url2=prop.getProperty("url2");
	}

	public void intialization(String url) {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browsername.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
