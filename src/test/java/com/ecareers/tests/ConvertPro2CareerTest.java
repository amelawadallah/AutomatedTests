package com.ecareers.tests;
import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.WebBaseTests;
import com.ecareers.pages.CareerFirstWizard;
import com.ecareers.pages.CareerFourthWizard;
import com.ecareers.pages.CareerSecondWizard;
import com.ecareers.pages.CareerThirdWizard;
import com.ecareers.pages.Convert2Career;
import com.ecareers.pages.LoginPage;
import com.ecareers.pages.ProFirstWizard;
import com.ecareers.pages.ProSecondWizard;
import com.ecareers.pages.ProThirdWizard;

public class ConvertPro2CareerTest extends WebBaseTests{
	
	LoginPage loginPg; 
	Convert2Career conv2Career;
	ProFirstWizard proFirstWzrd;
	ProSecondWizard proSecondWzrd;
	ProThirdWizard proThirdWzrd;
	CareerFirstWizard careerFirstWzrd;
	CareerSecondWizard careerSecondWzrd;
	CareerThirdWizard careerThirdWzrd;
	CareerFourthWizard careerFourthWzrd;
	public String appStatus ; 

	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException{
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		conv2Career = PageFactory.initElements(driver, Convert2Career.class);
		proFirstWzrd = PageFactory.initElements(driver, ProFirstWizard.class);
		proSecondWzrd = PageFactory.initElements(driver, ProSecondWizard.class);
		proThirdWzrd = PageFactory.initElements(driver, ProThirdWizard.class);
		careerFirstWzrd = PageFactory.initElements(driver, CareerFirstWizard.class);
		careerSecondWzrd = PageFactory.initElements(driver, CareerSecondWizard.class);
		careerThirdWzrd = PageFactory.initElements(driver, CareerThirdWizard.class);
		careerFourthWzrd = PageFactory.initElements(driver, CareerFourthWizard.class);
	}
	

	@Test
	public void testPro () throws InterruptedException{
		loginPg.loadPage();
		loginPg.loginToProfile("noor@testjawwal.com", "123456");
		Thread.sleep(2000);
		 appStatus = conv2Career.getCurrentAppType();
		System.out.println("Current status ........." + appStatus);
		conv2Career.fillFlow();
	}

	@Test(dependsOnMethods = "testPro")
	public void testPro2 () throws InterruptedException, AWTException{
		if (appStatus.equals("تحويل إلى طلب توظيف")){
			careerSecondWzrd.fillFlow();
			careerThirdWzrd.fillFlow();
			careerFourthWzrd.fillFlow();
		}else{
			proSecondWzrd.fillFlow();
			proThirdWzrd.fillFlow();
		}
	}
	
//	@Test(dependsOnMethods = "testPro2")
	public void testPro3 () throws InterruptedException, AWTException{
		proThirdWzrd.fillFlow();
	}
}
