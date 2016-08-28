package com.ecareers.tests;
import java.util.HashMap;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import com.WebBaseTests;
import com.ecareers.data.TestData;
import com.ecareers.pages.RegisterPage;

public class RegisterTest extends WebBaseTests{
	RegisterPage registerPg;
	HashMap<String,String> registerMap; 
	
	@Factory(dataProvider = "registerData" , dataProviderClass = TestData.class)
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
	}

	@Test	
	public void testSignUp() throws InterruptedException {		
		registerPg.loadPage();
		registerPg.register(registerMap.get("firstName"),registerMap.get("lastName"),registerMap.get("idType"),registerMap.get("idNumber"),registerMap.get("Email"),registerMap.get("mobileNumber"));
    }
}
