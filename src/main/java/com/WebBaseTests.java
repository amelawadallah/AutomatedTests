package com;
import static com.utilities.DriverFactory.getDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import com.utilities.DriverFactory;

public class WebBaseTests{
	
	protected  WebDriver driver; 
	public WebDriverWait _wait;
	final int BASE_TIMEOUT_SECONDS = 5 ;
	
	@BeforeTest//(alwaysRun = true )
	public void testsSetUp() throws IOException{
		driver = getDriver( DriverFactory.getBrowserTypeByProperty() );
	   _wait = new WebDriverWait(driver, BASE_TIMEOUT_SECONDS); 
	   driver.manage().timeouts().implicitlyWait(BASE_TIMEOUT_SECONDS, TimeUnit.SECONDS); 
	}
	
//	@AfterClass(alwaysRun = true)
	public void teardown(){
		driver.close();
	}
}
