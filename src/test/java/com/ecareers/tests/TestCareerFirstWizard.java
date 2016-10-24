package com.ecareers.tests;
import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.WebBaseTests;
import com.ecareers.data.TestFirstWizard;
import com.ecareers.data.TestRegisterData;
import com.ecareers.pages.CareerFirstWizard;
import com.ecareers.pages.CareerFourthWizard;
import com.ecareers.pages.CareerSecondWizard;
import com.ecareers.pages.CareerThirdWizard;
import com.ecareers.pages.LoginPage;

public class TestCareerFirstWizard extends WebBaseTests{
	
	LoginPage loginPg; 
	CareerFirstWizard careerFirstWzrd;
	CareerSecondWizard careerSecondWzrd;
	CareerThirdWizard careerThirdWzrd;
	CareerFourthWizard careerFourthWzrd;
	HashMap<String, String> careerMap;
	
	@Factory(dataProvider = "CorrectData" , dataProviderClass = TestFirstWizard.class)
	public  TestCareerFirstWizard(String firstName , String secondName , String thirdName, String lastName,
			String gender, String nationality, String maritalStatus, String birthPlace
			, String country , String address , String phoneNumber, String fax, String linkedinURL ){
		careerMap = new HashMap<String,String>();
		careerMap.put("firstName", firstName);
		careerMap.put("secondName", secondName);
		careerMap.put("thirdName", thirdName);
		careerMap.put("lastName", lastName);
		careerMap.put("gender", gender);
		careerMap.put("nationality", nationality);
		careerMap.put("maritalStatus", maritalStatus);
		careerMap.put("birthPlace", birthPlace);
		careerMap.put("country", country);
		careerMap.put("address", address);
		careerMap.put("phoneNumber", phoneNumber);
		careerMap.put("fax", fax);
		careerMap.put("linkedinURL", linkedinURL);
		
		
	}
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException{
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		careerFirstWzrd = PageFactory.initElements(driver, CareerFirstWizard.class);
//		careerSecondWzrd = PageFactory.initElements(driver, CareerSecondWizard.class);
//		careerThirdWzrd = PageFactory.initElements(driver, CareerThirdWizard.class);
//		careerFourthWzrd = PageFactory.initElements(driver, CareerFourthWizard.class);
	}

	@Test
	public void testCareer () throws InterruptedException, IOException{
		loginPg.loadPage();
		loginPg.loginToProfile("sari@testjawwal.com", "123456");
		Thread.sleep(2000);
		careerFirstWzrd.fillFlow(careerMap.get("firstName"),careerMap.get("secondName"),careerMap.get("thirName"),careerMap.get("lastName"),
				careerMap.get("gender"),careerMap.get("nationality"),careerMap.get("maritalStatus"),careerMap.get("birthPlace")
				,careerMap.get("country"),careerMap.get("address"),careerMap.get("phoneNumber"),
				careerMap.get("fax"),careerMap.get("linkedinURL"));		
	}
	
	//@Test(dependsOnMethods = "testCareer")
	public void testCareer2 () throws InterruptedException{
		careerSecondWzrd.fillFlow();
	}
	
	//@Test(dependsOnMethods = "testCareer2")
	public void testCareer3 () throws InterruptedException{
		careerThirdWzrd.fillFlow();
	}
	
	//@Test(dependsOnMethods = "testCareer3")
	public void testCareer4 () throws InterruptedException, AWTException{
		careerFourthWzrd.fillFlow();
	}
}
