package com.ecareers.tests;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.WebBaseTests;
import com.ecareers.data.TestData;
import com.ecareers.pages.LoginPage;

public class LoginTest extends WebBaseTests{

	LoginPage loginPg; 

	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException{
		loginPg = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test( dataProvider = "loginData" , dataProviderClass = TestData.class)
	public void testLoginSuccessfull (String email , String password ,String errorType){
		loginPg.loadPage();
		loginPg.loginToProfile(email, password);
		if(!StringUtils.isBlank(errorType)){
			boolean errorResult = loginPg.checkErrorMessage(errorType);
			Assert.assertTrue(errorResult, "Expected Error: " + errorType);
		}else {
		Assert.assertTrue(loginPg.button_accept.isDisplayed());
		
		}
	}
}
