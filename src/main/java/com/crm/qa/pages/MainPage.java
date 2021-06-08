package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRM_Base;

public class MainPage extends CRM_Base {
	
	// Page Factory || OR:
	
	@FindBy(xpath = "//a[@class = \"btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left\"]")
    WebElement main_Page_Login_Btn;	
	
	@FindBy(xpath = "//a[contains(@class , \"btn btn-sm btn-white btn-icon btn-icon-"
			+ "left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30\")]")
	WebElement main_Page_SignUp_Btn;
	
	@FindBy(xpath ="//a[contains(text(), 'About')]")
	WebElement aboutUs;
	
	@FindBy(xpath = "//div[@class = \"rd-navbar-brand\"]/a[@title = \"free crm home\" and @class= \"brand-name\"]")
	WebElement crmLogo;
	
	// initializing the Page Objects
	
	public MainPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	
	}

	public boolean validate_CRM_Image() {
		
		return crmLogo.isDisplayed();
		
	}
	
	public String validate_Main_Page_Title() {
		
        return driver.getTitle();
		
		
	}

	public LoginPage click_On_LoginBtn() throws IOException {
		
		main_Page_Login_Btn.click();
		return new LoginPage();
	}
	
	
}
