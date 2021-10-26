package com.qa.guru99.livedemo.test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.guru99.base.TestBase;
import com.qa.guru99.livedemo.pages.HomePage;


public class HomePageTest extends TestBase {

	HomePage homepage;
	SoftAssert softassert;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization(url2);
		homepage = new HomePage();
		softassert = new SoftAssert();
	}

	@Test
	public void verifyHomePage() {
		String title = driver.getTitle();
		softassert.assertEquals(title, "Home page");
		softassert.assertAll();
	}

	@Test
	public void verifyMobilePage() {
		homepage.validateHomePageLink("Mobile");
		String title = driver.getTitle();
		softassert.assertEquals(title, "Mobile");
		softassert.assertAll();
	}

}
