package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRM_Base;

public class ContactsPage extends CRM_Base {

	@FindBy(xpath = "//button[contains(text(),\"Create\")]")
	private WebElement Create_Contact;

	@FindBy(xpath = "//button[contains(text(),\"Export\")]")
	private WebElement Export;

	@FindBy(xpath = "//button[contains(text(),\"Show Filters\")]")
	WebElement Show_Filters;

	@FindBy(xpath = "//div[contains(text(),\"Contacts\")]")
	private WebElement Contacts_Header;

	@FindBy(xpath = "//span[@class= \"user-display\"]")
	private WebElement User_Name;
	
	@FindBy(xpath = "//a[contains(text(),\"'+name'\")]/parent::td/following-sibling::td[6]//i[@class= \"unhide icon\"]")
	private WebElement View_Contact;
	
	 

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void Move_Cursor_To_User_Name() {
		
	Actions action = new Actions(driver);
	action.moveToElement(User_Name).build().perform();
		
	}

	public boolean validate_Contacts_Heading() {
        
		return Contacts_Header.isDisplayed();

	}

	public String Validate_Contacts_Header_Text() {

		
		return Contacts_Header.getText();

	}

	public CreateNewContactsPage Click_On_Create() throws IOException {
		
//		JavascriptExecutor js = ((JavascriptExecutor)driver);
//		js.executeScript("arguments[0].click();", Create_Contact);
     	Create_Contact.click();
		return new CreateNewContactsPage();
		
	}
	
}
