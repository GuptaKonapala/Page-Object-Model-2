package com.qa.guru99.livedemo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.guru99.base.TestBase;
import com.qa.guru99.livedemo.pages.CartPageAndShoppingPage;
import com.qa.guru99.livedemo.pages.HomePage;
import com.qa.guru99.testUtil.TestUtil;

public class MobilePageTest extends TestBase {
	
	HomePage homepage;
	CartPageAndShoppingPage cartpage;
	SoftAssert softassert;
	
	public MobilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialization(url2);
		homepage = new HomePage();
		softassert = new SoftAssert();
		homepage.validateHomePageLink("Mobile");
		cartpage = new CartPageAndShoppingPage();
	}
	
	@Test
	public void verifySorting() {
		String product;
		ArrayList<String> ar = new ArrayList<String>();
		TestUtil.validateSorting("Name");
		List<WebElement> items = driver.findElements(By.xpath("//img[contains (@id, 'product-collection-image-')]"));
		Iterator<WebElement> it = items.iterator();
		while (it.hasNext()) {
			product = it.next().getAttribute("alt");
			ar.add(product);
		}
		ArrayList<String> ar2 = new ArrayList<String>();
		ar2.addAll(ar);
		Collections.sort(ar2);
		softassert.assertEquals(ar, ar2);
		softassert.assertAll();
	}
	
	@Test
	public void verifyProductPrice() {
		String mobilepageprice = TestUtil.validateProductPrice("Xperia");
		TestUtil.validateProductLinks("Xperia");
		String sonypageprice = TestUtil.validateProductPriceinProductPage();
		softassert.assertEquals(mobilepageprice, sonypageprice);
		softassert.assertAll();
	}
	
	@Test
	public void verifyAddToCompare() {
		ArrayList<String>productstocompare = new ArrayList<String>();
		productstocompare.add("SONY XPERIA");
		productstocompare.add("IPHONE");
		TestUtil.validateAddToCompare("IPhone");
		TestUtil.validateAddToCompare("Xperia");
		TestUtil.validateCompare();
		Set<String> handler = driver.getWindowHandles();		
		Iterator<String> it = handler.iterator();		
		String parentwindowid = it.next();
		String childwindowid = it.next();				
		driver.switchTo().window(childwindowid);			
	    String title = driver.findElement(By.xpath("//h1")).getText();
	    softassert.assertEquals(title, "COMPARE PRODUCTS");
	    List<WebElement> products = driver.findElements(By.xpath("//tr[@class='product-shop-row top first odd']//td//h2"));
	    ArrayList<String> compareproducts = new ArrayList<String> ();
	    for(WebElement e : products) {
	    	compareproducts.add(e.getText());
	    }
	    softassert.assertEquals(compareproducts, productstocompare);
		driver.close();			
		driver.switchTo().window(parentwindowid);		
		softassert.assertAll();
	}


}
