package com.qa.guru99.testUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.guru99.base.TestBase;

public class TestUtil extends TestBase{
	
	public static Workbook book;
	public static Sheet sheet;
	public static String filepath = "E:\\Java_Selenium\\Guru99Project\\src\\main\\java\\com\\qa\\guru99\\testdata\\TestData.xlsx";
	
	public static void select(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static Object[][] getdatamethod(String sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i<sheet.getLastRowNum(); i++) {
			for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++) {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	public static void validateAddToCart(String productname) {
		driver.findElement(By.xpath("//a[@title='"+productname+"']/following-sibling::div//div[@class='actions']//button")).click();
	}
	
	public static void validateProductLinks(String productname) {
		driver.findElement(By.xpath("//img[@alt='"+productname+"']")).click();
	}
	
	public static String validateProductPrice(String productname) {
		return driver.findElement(By.xpath("//a[@title='"+productname+"']/following-sibling::div//h2/following-sibling::div//span[@class='price']")).getText();
	}
	
	public static void validateSorting(String sortby) {
		TestUtil.select(driver.findElement(By.xpath("//select[@title='Sort By']")), sortby);
	}
	
	public static void validateAddToCompare(String productname) {
		driver.findElement(By.xpath("//a[@title='"+productname+"']/following-sibling::div//ul//a[@class='link-compare']")).click();
	}
	
	public static void validateCompare() {
		driver.findElement(By.xpath("//button[@title ='Compare']")).click();
	}
	
	public static void validateAddToWishlist(String productname) {
		driver.findElement(By.xpath("//a[@title='"+productname+"']/following-sibling::div//ul//a[@class='link-wishlist']")).click();
	}
	
	public static String validateProductPriceinProductPage() {
		return driver.findElement(By.cssSelector(".price")).getText();
	}
	
	public static String validatePageTitle() {
		return driver.getTitle();
	}
	
	public static String getmessage() {
		return driver.findElement(By.xpath("//li//span")).getText();
	}

}
