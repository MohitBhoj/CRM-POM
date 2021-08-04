package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRM_Base;

public class CreateNewContactsPage extends CRM_Base {
	
	@FindBy (xpath = "//input[@name= \"first_name\"]")
    WebElement First_Name;
	
	@FindBy (xpath = "//input[@name= \"last_name\"]")
    WebElement Last_Name;
	
	@FindBy (xpath = "//input[@name= \"middle_name\"]")
    WebElement Middle_Name;
	
	@FindBy (xpath = "//div[@name=\"company\"]")
    WebElement Company_Name;
	
	@FindBy (xpath = "//button[@class = \"ui linkedin button\"]")
    WebElement Save;
	
	
	
	
	public CreateNewContactsPage() throws IOException {
		PageFactory.initElements(driver,this);
	}

	
	public void fill_Contacts_Form(String FirstName, String MiddleName, String LastName, String Company) {
		
		First_Name.sendKeys(FirstName);
		Middle_Name.sendKeys(MiddleName);
		Last_Name.sendKeys(LastName);
		Company_Name.sendKeys(Company);
			
	}
	
	public void click_On_Save_button() {
		
		Save.click();
		
	}
	
	
	
}
