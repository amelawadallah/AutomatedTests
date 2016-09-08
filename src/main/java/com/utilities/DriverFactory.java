package com.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class DriverFactory{

    public enum BrowserType{
        
		FIREFOX("firefox"),
        CHROME("chrome"),
        IE("internet_explorer"),
        SAFARI("safari");
		
		private String value;
        BrowserType(String value){
            this.value = value;
        }

        public String getBrowserName(){
            return this.value;
        }
    }

    public static WebDriver getDriver(BrowserType type){
		WebDriver driver = null ;
		switch(type){
		 	case FIREFOX:
//		 		driver = new FirefoxDriver();
		 		ProfilesIni profile = new ProfilesIni();
		 		FirefoxProfile myprofile = profile.getProfile("QATools");
		 		driver = new FirefoxDriver(myprofile);
		 		break;
		 	case CHROME:
		 		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
		 		break;
		 	default:
		 		driver = new FirefoxDriver();
		 	
		}
		return driver;
	}
    
    public static  BrowserType getBrowserTypeByProperty() throws IOException{
		BrowserType type = null ;
		File file = new File("src/test/resources/local.properties");
		FileInputStream fileInput =  new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String browserName = prop.getProperty("BROWSER");
		System.out.println("BrowserName:   "+browserName);
		for(BrowserType bType :  BrowserType.values()){
			if (bType.getBrowserName().equalsIgnoreCase(browserName)){
				type = bType;
				System.out.println("BrowserType  "+bType);
		   }
		}
		return type;
	}
}