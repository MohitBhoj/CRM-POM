package com.crm.qa.tests;

import org.testng.TestNG;

public class Runnable {
	
	static TestNG testNG;

	public static void main(String[] args) {
		
			testNG =  new TestNG();
			testNG.setTestClasses(new Class[] {MainPageTest.class, LoginPageTest.class, HomePageTest.class});
			
			testNG.run();
		
		}

	}


