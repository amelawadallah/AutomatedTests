package com.ecareers.tests;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.mail.MessagingException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.WebBaseTests;
import com.ecareers.data.TestRegisterData;
import com.ecareers.pages.CheckEmail;
import com.ecareers.pages.LoginPage;
import com.ecareers.pages.RegisterPage;

public class RegisterTest extends WebBaseTests{
	
	RegisterPage registerPg;
	LoginPage  loginPg;
	HashMap<String,String> registerMap; 
	
	@Factory(dataProvider = "RegisterData" , dataProviderClass = TestRegisterData.class)
	public  RegisterTest(String firstName , String lastName, String idType, String idNumber, String Email, String mobileNumber){
		registerMap = new HashMap<String,String>();
		registerMap.put("firstName", firstName);
		registerMap.put("lastName", lastName);
		registerMap.put("idType", idType);
		registerMap.put("idNumber", idNumber);
		registerMap.put("Email", Email);
		registerMap.put("mobileNumber", mobileNumber);		
	}
	

		
	@BeforeTest(alwaysRun = true)
	public void setup(){		
		registerPg = PageFactory.initElements(driver, RegisterPage.class);
		loginPg = PageFactory.initElements(driver, LoginPage.class);
	
	}

	@Test	
	public void testSignUp() throws InterruptedException, IOException {		
		 System.out.println("Starting test:  testSignUp " );
		registerPg.loadPage();
		registerPg.register(registerMap.get("firstName"),registerMap.get("lastName"),registerMap.get("idType"),registerMap.get("idNumber"),registerMap.get("Email"),registerMap.get("mobileNumber"));
		registerPg.CheckSuccessfulRegistration();
    }
	
	@Test(dependsOnMethods="testSignUp")	
	public void testLoginWithSignUp() throws InterruptedException, MessagingException, IOException {		
		 System.out.println("Starting test:  testLoginWithSignUp " );

		loginPg.loadPage();
		CheckEmail checkEmail = new CheckEmail();
		String password = checkEmail.getPassword();
		loginPg.loginToProfile(registerMap.get("Email"), password);	
    }

	@Test( dependsOnMethods="testLoginWithSignUp", dataProvider = "EmptyfieldsValidation" , dataProviderClass = TestRegisterData.class)	
	public void testEmptyfieldsValidation(String firstName, String lastName ,String IdType, String IdNumber, String Email, String mobileNumber, String errorType) throws InterruptedException, MessagingException, IOException {		
		 System.out.println("Starting test:  testEmptyfieldsValidation " );
		registerPg.loadPage();
		registerPg.register(firstName,lastName, IdType, IdNumber ,Email, mobileNumber);
		registerPg.checkEmptyFieldsErrors(errorType);
		
    }
	
	
	@Test( dependsOnMethods = "testEmptyfieldsValidation", dataProvider = "WrongFormats" , dataProviderClass = TestRegisterData.class)	
	public void testWrongFormats(String firstName, String lastName ,String IdType, String IdNumber,String Email, String mobileNumber, String errorType) throws InterruptedException, MessagingException, IOException {		
		System.out.println("Starting test:  testWrongFormats " );
		registerPg.loadPage();
		registerPg.register(firstName,lastName, IdType, IdNumber ,Email, mobileNumber);
		registerPg.checkEmptyFieldsErrors(errorType);

    }
	
	@Test( dependsOnMethods = "testWrongFormats", dataProvider = "RegisteredUserData" , dataProviderClass = TestRegisterData.class)	
	public void testRegisteredUserData(String errorType)throws InterruptedException, MessagingException, IOException {		
	
		System.out.println("Starting test:  testRegisteredUserData " );

		registerPg.loadPage();
		registerPg.register(registerMap.get("firstName"),registerMap.get("lastName"),registerMap.get("idType"),registerMap.get("idNumber"),registerMap.get("Email"),registerMap.get("mobileNumber"));
		registerPg.checkEmptyFieldsErrors(errorType);

    }
}
