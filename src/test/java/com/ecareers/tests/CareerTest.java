package com.ecareers.tests;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.WebBaseTests;
import com.ecareers.pages.CareerFirstWizard;
import com.ecareers.pages.CareerSecondWizard;
import com.ecareers.pages.LoginPage;

public class CareerTest extends WebBaseTests{
	
	LoginPage loginPg; 
	CareerFirstWizard careerFirstWzrd;
	CareerSecondWizard careerSecondWzrd;

	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException{
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		careerFirstWzrd = PageFactory.initElements(driver, CareerFirstWizard.class);
	}

	@Test
	public void testCareer () throws InterruptedException{
		loginPg.loadPage();
		loginPg.loginToProfile("amel@testJawwal.com", "123456");
		Thread.sleep(2000);
		careerFirstWzrd.fillFlow();
		
		
	}
	
	@Test(dependsOnMethods = "testCareer")
	public void testCareer2 () throws InterruptedException{
	
		
		careerSecondWzrd.fillFlow();
		
		
	}
}
