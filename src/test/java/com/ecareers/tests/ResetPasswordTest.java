 package com.ecareers.tests;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.WebBaseTests;
import com.ecareers.pages.ResetPasswordPage;

public class ResetPasswordTest extends WebBaseTests{

	ResetPasswordPage resetPasswordPg; 

	@BeforeClass(alwaysRun = true)
	public void setMeUp(){
		resetPasswordPg = PageFactory.initElements(driver, ResetPasswordPage.class);
	}

	@Test
	public void testResetByEmail(){
		resetPasswordPg.loadPage();
		resetPasswordPg.resetByEmail();
	}
	
//	@Test
	public void testResetBySms(){
		resetPasswordPg.loadPage();
		resetPasswordPg.resetBySMS();
	}
}
