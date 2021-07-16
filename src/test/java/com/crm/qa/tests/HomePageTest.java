package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRM_Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class HomePageTest extends CRM_Base {

	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	
	public HomePageTest() throws IOException {
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initialization();
		
		mainPage = new MainPage();
		loginPage= new LoginPage();
		//contactPage = new ContactPage();
		loginPage = mainPage.click_On_LoginBtn();
		homePage = loginPage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void home_Page_Title_Test() {
		
		String home_Page_Title = homePage.validate_Home_Page_Title();
		Assert.assertEquals("Cogmento CRM", home_Page_Title);
	}
	
	@Test(priority=2)
	public void user_Name_Test() {
		
		String user_Name = homePage.validate_User_Name();
		Assert.assertEquals("Mohit Bhoj",user_Name);
	}
	
	
	@Test(priority=3)
	public void home_Page_Logo_Test() {
		
		Assert.assertTrue(homePage.validate_Home_page_Logo());
		
	}
	
	@Test(priority=4)
	public void click_On_Create_Contact_Test() throws IOException {
		
		contactPage = homePage.click_On_Contact();
	
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	

	
	
	
}
