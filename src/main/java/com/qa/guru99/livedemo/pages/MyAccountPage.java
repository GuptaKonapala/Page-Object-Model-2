package com.qa.guru99.livedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class MyAccountPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='block-content']//ul//li//a[contains(text(), 'My Wishlist')]")
	public static WebElement wishlist1;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
