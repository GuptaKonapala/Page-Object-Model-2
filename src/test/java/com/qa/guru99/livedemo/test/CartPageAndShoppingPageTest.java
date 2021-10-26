package com.qa.guru99.livedemo.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.guru99.base.TestBase;
import com.qa.guru99.livedemo.pages.CartPageAndShoppingPage;
import com.qa.guru99.livedemo.pages.HomePage;
import com.qa.guru99.livedemo.pages.LoginPage;
import com.qa.guru99.livedemo.pages.MyAccountPage;
import com.qa.guru99.livedemo.pages.MyWishListPage;
import com.qa.guru99.testUtil.TestUtil;

public class CartPageAndShoppingPageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	CartPageAndShoppingPage cartpage;
	SoftAssert softassert;
	
	public CartPageAndShoppingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialization(url2);
		homepage = new HomePage();
		homepage.validateHomePageLink("Mobile");
		loginpage = new LoginPage();
		cartpage = new CartPageAndShoppingPage();
		softassert = new SoftAssert();
	}
	
	//@Test
	public void verifyAddToCart() {
		TestUtil.validateAddToCart("Xperia");
		cartpage.quantity("1000");
		String message = driver.findElement(By.xpath("//ul[@class='messages']")).getText();
		softassert.assertEquals(message, "Some of the products cannot be ordered in requested quantity.");
		cartpage.emptycart.click();
		String emptymessage = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
		softassert.assertEquals(emptymessage, "SHOPPING CART IS EMPTY");
		softassert.assertAll();
	}
	
	@Test
	public void verifyEndtoEnd() throws InterruptedException {
		homepage.validateMyAccountLink();
		loginpage.validateLogin("guptakforsociety@gmail.com", "gerorge");
		MyAccountPage.wishlist1.click();
		Thread.sleep(5000);
		MyWishListPage.addtocart();
		CartPageAndShoppingPage.proceedtocheckout.click();
		cartpage.billinginformation("", "", "", "als", "bomm", "strt", "city", "Alaska", "567782", "9087654567");
	}

}
