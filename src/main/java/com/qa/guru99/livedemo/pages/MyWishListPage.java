package com.qa.guru99.livedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class MyWishListPage extends TestBase{
	
	@FindBy(xpath = "//button[@title='Share Wishlist']")
	WebElement sharewishlist;
	
	@FindBy(css = "#message")
	WebElement mesage;
	
	@FindBy(xpath = "//div[@class='my-account']//div//form//div//table/tbody//tr//td[5]//div//button")
	public static WebElement addcart;
	
	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void shareWishList(String mail, String message) {
		sharewishlist.click();
		CreateNewCustomerAccountPage.mail.sendKeys(mail);
		mesage.sendKeys(message);
		sharewishlist.click();
	}
	
	public static void addtocart() {
		addcart.click();
	}

}
