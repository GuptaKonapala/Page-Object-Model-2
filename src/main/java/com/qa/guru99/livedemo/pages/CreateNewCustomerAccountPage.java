package com.qa.guru99.livedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class CreateNewCustomerAccountPage extends TestBase{
	
	@FindBy(css = "#firstname")
	WebElement fname;
	
	@FindBy(css = "#middlename")
	WebElement mname;
	
	@FindBy(css = "#lastname")
	WebElement lname;
	
	@FindBy(css = "#email_address")
	public static WebElement mail;
	
	@FindBy(css = "#password")
	WebElement passkey;
	
	@FindBy(css = "#confirmation")
	WebElement confirmpasskey;
	
	@FindBy(xpath = "//button[@title='Register']")
	WebElement register;
	
	public CreateNewCustomerAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public MyAccountPage validateCreateNewCustomerAccount(String firstname, String middlename, String lastname, String email, String password) {
		fname.sendKeys(firstname);
		mname.sendKeys(middlename);
		lname.sendKeys(lastname);
		mail.sendKeys(email);
		passkey.sendKeys(password);
		confirmpasskey.sendKeys(password);
		register.click();
		driver.getTitle();
		return new MyAccountPage();
	}

}
