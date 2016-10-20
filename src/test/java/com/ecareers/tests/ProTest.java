package com.ecareers.tests;
import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.WebBaseTests;
import com.ecareers.pages.LoginPage;
import com.ecareers.pages.ProFirstWizard;
import com.ecareers.pages.ProSecondWizard;
import com.ecareers.pages.ProThirdWizard;

public class ProTest extends WebBaseTests{
	
	LoginPage loginPg; 
	ProFirstWizard proFirstWzrd;
	ProSecondWizard proSecondWzrd;
	ProThirdWizard proThirdWzrd;
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException{
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		proFirstWzrd = PageFactory.initElements(driver, ProFirstWizard.class);
		proSecondWzrd = PageFactory.initElements(driver, ProSecondWizard.class);
		proThirdWzrd = PageFactory.initElements(driver, ProThirdWizard.class);
	}
	
	@Test
	public void testPro () throws InterruptedException{
		loginPg.loadPage();
		loginPg.loginToProfile("noor@testjawwal.com", "123456");
		Thread.sleep(2000);
		proFirstWzrd.fillFlow();	
	}
	
	@Test(dependsOnMethods = "testPro")
	public void testPro2 () throws InterruptedException{
		proSecondWzrd.fillFlow();	
	}
	
	@Test(dependsOnMethods = "testPro2")
	public void testPro3 () throws InterruptedException, AWTException{
		proThirdWzrd.fillFlow();	
	}
}
