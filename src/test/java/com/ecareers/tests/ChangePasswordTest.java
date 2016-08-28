package com.ecareers.tests;
import java.util.HashMap;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import com.WebBaseTests;
import com.ecareers.data.TestData;
import com.ecareers.pages.ChangePasswordPage;
import com.ecareers.pages.LoginPage;

public class ChangePasswordTest extends WebBaseTests{

	ChangePasswordPage changePasswordPg; 
	LoginPage loginPg ;
	HashMap<String,String> passwordMap; 

	@Factory(dataProvider = "changePasswordData", dataProviderClass= TestData.class)
	public ChangePasswordTest(String oldPass , String newPass, String confirmPass){
		passwordMap = new HashMap<String, String>();
		passwordMap.put("oldPassword", oldPass);
		passwordMap.put("newPassword", newPass);
		passwordMap.put("confirmPassword", confirmPass);
	}
	
	@BeforeClass(alwaysRun = true)
	public void setup(){	
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		changePasswordPg = PageFactory.initElements(driver, ChangePasswordPage.class);
	}

	@Test
	public void testChangePassword() throws InterruptedException {
		changePasswordPg.loadPage();
		Thread.sleep(4000);
		loginPg.loginToProfile("amal.awadallah@jawwal.ps","ufuj88k8Y8");
		Thread.sleep(4000);
		changePasswordPg.changePassword(passwordMap.get("oldPassword"), passwordMap.get("newPassword"),passwordMap.get("confirmPassword"));
	}
}
