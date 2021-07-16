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
	private WebElement home_Page_Logo;
	
	@FindBy(xpath = "//span[@class= 'user-display']")
	private WebElement user_Name;
	
	@FindBy(xpath = "//span[contains(text(),\"Contacts\")]")
	private WebElement contacts;
	
//	@FindBy(xpath = "//i[@class= 'plus inverted icon']")
//	private WebElement create_Contact;
//	
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
	
	public ContactsPage click_On_Contact() throws IOException {
		
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		contacts.click();
		
		return new ContactsPage();
		
	}
	
	
}
