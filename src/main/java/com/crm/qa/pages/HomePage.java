package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRM_Base;

public class HomePage extends CRM_Base{

	
	
	//Page-Factory ||OR
	
	@FindBy(xpath = "//div[@class= 'header item']")
	WebElement home_Page_Logo;
	
	@FindBy(xpath = "//span[@class= 'user-display']")
	WebElement user_Name;
	
	@FindBy(xpath = "//i[@class='users icon']")
	WebElement contacts;
	
	@FindBy(xpath = "//i[@class= 'plus inverted icon']")
	WebElement create_Contact;
	
	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	
	}
	
	public String validate_Home_Page_Title() {
		
		return driver.getTitle();
		
	}
	
	public String validate_User_Name() {
		
		return user_Name.getText();
		
	}
	
	public boolean validate_Home_page_Logo() {
		
		return home_Page_Logo.isDisplayed();
		
	}
	
	public ContactPage click_On_Create_Contact() {
		
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		create_Contact.click();
		
		return new ContactPage();
		
	}
	
	
}
