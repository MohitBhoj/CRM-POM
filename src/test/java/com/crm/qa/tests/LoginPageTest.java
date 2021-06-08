package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRM_Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class LoginPageTest extends CRM_Base {

	LoginPage loginPage;
	MainPage mainPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
	
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initialization();
		mainPage = new MainPage();
		loginPage = mainPage.click_On_LoginBtn();
		
	}

	@Test(priority=1)
	public void login_Page_Title_Test() {
		
	String login_Page_Title = loginPage.validate_Login_Page_Title();
	Assert.assertEquals(login_Page_Title, "Cogmento CRM", "Login Page Title does notmatch");
		
	}
	
	
	@Test(priority=2)
	public void login_Test() {
		
		homePage = loginPage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod()
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
}
