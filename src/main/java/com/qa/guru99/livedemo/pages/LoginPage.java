package com.qa.guru99.livedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//a[@title='Create an Account']")
	WebElement createanaccount;
	
	@FindBy(name = "login[username]")
	WebElement user;
	
	@FindBy(name = "login[password]")
	WebElement passkey;
	
	@FindBy(name = "send")
	WebElement login;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CreateNewCustomerAccountPage validateCreateAnAccountLink() {
		createanaccount.click();
		return new CreateNewCustomerAccountPage();
	}
	
	public MyAccountPage validateLogin(String username, String password) {
		user.sendKeys(username);
		passkey.sendKeys(password);
		login.click();
		return new MyAccountPage();
	}

}
