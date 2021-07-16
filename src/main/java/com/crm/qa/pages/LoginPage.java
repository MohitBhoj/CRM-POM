package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRM_Base;

public class LoginPage extends CRM_Base{

    // Page Factory || OR:
	
	@FindBy(xpath = "//input[contains(@name,'email')]")
	private WebElement email_Address;
	
	@FindBy(xpath = "//input[contains(@name,'password')]")
	private WebElement password;
	
	@FindBy(xpath = "//div[contains(@class,'ui fluid large blue submit button')]")
	private WebElement login_Button;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password')]")
	private WebElement forgot_Password_Link;
	
	@FindBy(xpath = "//a[contains(text(),'Classic CRM')]")
	private WebElement classic_CRM_Link;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement sign_Up_Link;
	
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}


	public String validate_Login_Page_Title() {
	
	return driver.getTitle();
	
}
	
	public HomePage login(String email, String pwd) throws IOException {
		
		email_Address.click();
		email_Address.clear();
		email_Address.sendKeys(email);
		password.click();
		password.clear();
		password.sendKeys(pwd);
		login_Button.click();
		return new HomePage();
		
	}
	
	
}
