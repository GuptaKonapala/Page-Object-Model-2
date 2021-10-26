package com.qa.guru99.livedemo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.base.TestBase;
import com.qa.guru99.livedemo.pages.CreateNewCustomerAccountPage;
import com.qa.guru99.livedemo.pages.HomePage;
import com.qa.guru99.livedemo.pages.LoginPage;
import com.qa.guru99.livedemo.pages.MyWishListPage;
import com.qa.guru99.testUtil.TestUtil;

public class CreateNewCustomerAccountPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	CreateNewCustomerAccountPage newaccountpage;
	MyWishListPage wishlist;
	
	public CreateNewCustomerAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialization(url2);
		homepage = new HomePage();
		homepage.validateMyAccountLink();
		loginpage = new LoginPage();
		loginpage.validateCreateAnAccountLink();
		newaccountpage = new CreateNewCustomerAccountPage();
		wishlist = new MyWishListPage();
	}
	
	@Test
	public void verifyRegistrationCumWishlistShare() throws InterruptedException {
		newaccountpage.validateCreateNewCustomerAccount("harsh", "mehta", "george", "guptakforsociety4@gmail.com", "gerorge");
		System.out.println(TestUtil.getmessage());
		Assert.assertEquals(TestUtil.getmessage(), "Thank you for registering with Main Website Store.");
		System.out.println(TestUtil.validatePageTitle());
		Assert.assertEquals(TestUtil.validatePageTitle(), "My Account");
		homepage.validateHomePageLink("TV");
		TestUtil.validateAddToWishlist("LG LCD");
		wishlist.shareWishList("guptakforsociety@gmail.com", "Hi, This is for Testing");
		System.out.println(TestUtil.getmessage());
		Assert.assertEquals(TestUtil.getmessage(), "Your Wishlist has been shared.");
	}
	
	

}
