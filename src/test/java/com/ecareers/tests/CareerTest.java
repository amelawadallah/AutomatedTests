package com.ecareers.tests;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.WebBaseTests;
import com.ecareers.pages.CareerFirstWizard;
import com.ecareers.pages.CareerSecondWizard;
import com.ecareers.pages.CareerThirdWizard;
import com.ecareers.pages.LoginPage;

public class CareerTest extends WebBaseTests{
	
	LoginPage loginPg; 
	CareerFirstWizard careerFirstWzrd;
	CareerSecondWizard careerSecondWzrd;
	CareerThirdWizard careerThirdWzrd;

	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException{
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		careerFirstWzrd = PageFactory.initElements(driver, CareerFirstWizard.class);
		careerSecondWzrd = PageFactory.initElements(driver, CareerSecondWizard.class);
		careerThirdWzrd = PageFactory.initElements(driver, CareerThirdWizard.class);
	}
	

	@Test
	public void testCareer () throws InterruptedException{
		loginPg.loadPage();
		loginPg.loginToProfile("noor@testJawwal.com", "123456");
		Thread.sleep(2000);
		careerFirstWzrd.fillFlow();
		
		
	}
	
	@Test(dependsOnMethods = "testCareer")
	public void testCareer2 () throws InterruptedException{
	
		
		careerSecondWzrd.fillFlow();
		
		
	}
	
	@Test(dependsOnMethods = "testCareer2")
	public void testCareer3 () throws InterruptedException{
	
		
		careerThirdWzrd.fillFlow();
		
		
	}
}
