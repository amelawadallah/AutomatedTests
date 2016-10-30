package com.ecareers.tests;
import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.WebBaseTests;
import com.ecareers.data.DataFirstWizard;
import com.ecareers.pages.CareerFirstWizard;
import com.ecareers.pages.CareerFourthWizard;
import com.ecareers.pages.CareerSecondWizard;
import com.ecareers.pages.CareerThirdWizard;
import com.ecareers.pages.LoginPage;

public class CareerTest extends WebBaseTests{
	
	LoginPage loginPg; 
	CareerFirstWizard careerFirstWzrd;
	CareerSecondWizard careerSecondWzrd;
	CareerThirdWizard careerThirdWzrd;
	CareerFourthWizard careerFourthWzrd;

	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException{
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		careerFirstWzrd = PageFactory.initElements(driver, CareerFirstWizard.class);
		careerSecondWzrd = PageFactory.initElements(driver, CareerSecondWizard.class);
		careerThirdWzrd = PageFactory.initElements(driver, CareerThirdWizard.class);
		careerFourthWzrd = PageFactory.initElements(driver, CareerFourthWizard.class);
	}

	@Test(dataProvider = "CorrectData" , dataProviderClass= DataFirstWizard.class)
	public void testCareer () throws InterruptedException{
		loginPg.loadPage();
		loginPg.loginToProfile("sari@testjawwal.com", "123456");
		Thread.sleep(2000);
//		careerFirstWzrd.fillFlow(String firstName ,);		
	}
	
	@Test(dependsOnMethods = "testCareer")
	public void testCareer2 () throws InterruptedException{
//		careerSecondWzrd.fillFlow();
	}
	
	@Test(dependsOnMethods = "testCareer2")
	public void testCareer3 () throws InterruptedException{
		careerThirdWzrd.fillFlow();
	}
	
	@Test(dependsOnMethods = "testCareer3")
	public void testCareer4 () throws InterruptedException, AWTException{
		careerFourthWzrd.fillFlow();
	}
}
