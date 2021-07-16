package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRM_Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class ContactsPageTest extends CRM_Base {

	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	CreateNewContactPage createNewContactPage;
	
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
	}
	
	
	
	
	@Test(priority=0)
	public void Contacts_Heading_Visibility_Test() {
		
		contactsPage.Move_Cursor_To_User_Name();
		Assert.assertTrue(contactsPage.validate_Contacts_Heading());
	}
	
	@Test(priority=1)
	public void Contacts_Heading_Text_Test() {
		
		contactsPage.Move_Cursor_To_User_Name();
		String actual_Text = contactsPage.Validate_Contacts_Header_Text();
		
		Assert.assertEquals(actual_Text, "Contacts");
		
	}
	
	@Test(priority=3)
	public void Click_On_Create_Test() {
		
		createNewContactPage = contactsPage.Click_On_Create();
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
}
