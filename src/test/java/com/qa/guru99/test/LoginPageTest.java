package com.qa.guru99.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru99.base.TestBase;
import com.qa.guru99.pages.LoginPage;
import com.qa.guru99.testUtil.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialization(url);
		loginpage = new LoginPage();
	}
	@Test
	public void verifyLogin() {
		loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
	}
	@DataProvider
	public Object[][] getdata() {
		return TestUtil.getdatamethod("Sheet1");
	}
	@Test(dataProvider = "getdata")
	public void verifyLoginWithDDT(String un, String pw, String result) {
		loginpage.validateLogin(un, pw);
		try {
			Assert.assertEquals(driver.getTitle(), result);
			Assert.assertEquals(driver.switchTo().alert().getText(), result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
