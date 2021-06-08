package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class CRM_Base {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public CRM_Base() throws IOException {
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("/home/mohit/eclipse-workspace/POM/src/main/java/"+
				"com/rm/qa/config/config.properties");
		prop.load(ip);
		
	}
	
	public static void initialization() throws IOException {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver" , "./Drivers/chromedriver");
			driver = new ChromeDriver();
			
		}else if (browserName.equals("firefox")) {
		
			// setproperty for firefox web drive
		
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
		
	}
	
	
	
}
