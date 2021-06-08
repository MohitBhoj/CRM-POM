package com.crm.qa.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.CRM_Base;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class MainPageTest extends CRM_Base{
	
	MainPage mainPage;
	LoginPage loginPage;

	public MainPageTest() throws IOException {
		
		super();
		
	} 
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initialization();
		mainPage = new MainPage();
		
	}
	
	@Test(priority=0)
	public void crm_Logo_Test() {
		
		boolean logo = mainPage.validate_CRM_Image(); 
		Assert.assertTrue(logo);
		
	}
	
	@Test(priority=1)
	public void Main_Page_Title_Test() {
	
		String main_Page_Title = mainPage.validate_Main_Page_Title();
		Assert.assertEquals(main_Page_Title, "#1 Free CRM customer relationship management software cloud");
		
	}
	
	@Test(priority=2)
	public void main_Page_Login_Btn_Click_Test() throws IOException {
		
		loginPage = mainPage.click_On_LoginBtn();
				
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	

}
