package com.qa.guru99.livedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//div[@class='footer']//div//ul//li//a[@title='My Account']")
	WebElement myaccount;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateHomePageLink(String linkname) {
		driver.findElement(By.xpath("//a[contains (text(), '"+linkname+"' )]")).click();
	}
	
	public LoginPage validateMyAccountLink() {
		myaccount.click();
		return new LoginPage();
	}
	
	

}
