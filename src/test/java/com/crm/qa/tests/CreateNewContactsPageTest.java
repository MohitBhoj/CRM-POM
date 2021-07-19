package com.crm.qa.tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.CRM_Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import com.crm.qa.util.TestUtil;

public class CreateNewContactsPageTest extends CRM_Base{

	public CreateNewContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	String sheetName = "contacts";
	
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	CreateNewContactsPage createNewContactsPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initialization();
		
		mainPage = new MainPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		loginPage = mainPage.click_On_LoginBtn();
		homePage = loginPage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
		contactsPage = homePage.click_On_Contact();
		createNewContactsPage = contactsPage.Click_On_Create();
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String FirstName, String MiddleName, String LastName, String Company){
		
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		createNewContactsPage.fill_Contacts_Form(FirstName,MiddleName,LastName,Company);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
}
