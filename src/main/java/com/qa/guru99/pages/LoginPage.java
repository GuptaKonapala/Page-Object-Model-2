package com.qa.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateLogin(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
	}

}
