package com.qa.guru99.livedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;
import com.qa.guru99.testUtil.TestUtil;

public class CartPageAndShoppingPage extends TestBase{
	
	@FindBy(xpath = "//td[@class='product-cart-actions']//input")
	WebElement quantity;
	
	@FindBy(css = "#empty_cart_button")
	public WebElement emptycart;
	
	@FindBy(css = "button[class = 'button btn-proceed-checkout btn-checkout']")
	public static WebElement proceedtocheckout;
	
	@FindBy(id = "billing:firstname")
	WebElement fname;
	
	@FindBy(id = "billing:middlename")
	WebElement mname;
	
	@FindBy(id = "billing:lastname")
	WebElement lname;
	
	@FindBy(id = "billing:company")
	WebElement compani;
	
	@FindBy(id = "billing:street1")
	WebElement addres;

	@FindBy(id = "billing:street2")
	WebElement addres2;

	@FindBy(id = "billing:city")
	WebElement place;
	
	@FindBy(css = "select[id = 'billing:region_id']")
	WebElement state;
	
	@FindBy(id = "billing:postcode")
	WebElement zip;

	@FindBy(id = "billing:telephone")
	WebElement phone;
	
	@FindBy(css = "button[onclick='billing.save()']")
	WebElement continuee;
	
	@FindBy(css = "#p_method_checkmo")
	WebElement money;
	
	@FindBy(css = "[title='Place Order']")
	WebElement placeorder;
	
	public CartPageAndShoppingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void quantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
		driver.findElement(By.xpath("//button[@title='Update']")).click();
	}
	
	public void billinginformation(String firstname, String middlename, String lastname, String company, String address, String street, String city, String USAstate, String pincode, String phonenumber) {
		fname.sendKeys(firstname);
		mname.sendKeys(middlename);
		lname.sendKeys(lastname);
		compani.sendKeys(company);
		addres.sendKeys(address);
		addres2.sendKeys(street);
		place.sendKeys(city);
		TestUtil.select(state, USAstate);
		zip.sendKeys(pincode);
		phone.sendKeys(phonenumber);
		continuee.click();
		continuee.click();
		money.click();
		continuee.click();
		placeorder.click();
	}

}
