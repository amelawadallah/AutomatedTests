package com.ecareers.tests;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.WebBaseTests;
import com.ecareers.data.TestData;
import com.ecareers.data.TestLoginData;
import com.ecareers.pages.LoginPage;

public class LoginTest extends WebBaseTests{

	LoginPage loginPg; 

	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException{
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		
	}

	@Test( dataProvider = "loginData" , dataProviderClass = TestLoginData.class)
	public void testLoginSuccess (String email , String password ,String errorType) throws IOException{
		
		loginPg.loadPage();
		loginPg.loginToProfile(email, password);
		loginPg.checkErrorsswitch(errorType);
		
	}
	
	@Test( dataProvider = "wrongLoginData" , dataProviderClass = TestLoginData.class)
	public void testWrongCredentials (String email , String password ,String errorType) throws IOException{
		
		loginPg.loadPage();
		loginPg.loginToProfile(email, password);
		loginPg.checkErrorsswitch(errorType);
		
	}
	
	
	@Test( dataProvider = "loginDataValidation" , dataProviderClass = TestLoginData.class)
	public void testfieldValidation (String email , String password ,String errorType) throws IOException{
		
		loginPg.loadPage();
		loginPg.loginToProfile(email, password);
		loginPg.checkErrorsswitch(errorType);
		
	}
}

