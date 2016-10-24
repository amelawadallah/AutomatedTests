package com;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage{

	public WebDriver driver; 
	public WebDriverWait wait;
	public String PAGE_URL;
	public String PAGE_TITLE;
	
	public BasePage(WebDriver driver){
		this.driver = driver ;
		wait = new WebDriverWait(driver, 1000);
	}

	public void loadPage(){
		driver.get(getPageUrl());
		Assert.assertEquals(driver.getTitle(), getPageTitle());
	}
	
	public String getPageUrl(){
		return PAGE_URL ;	
	}
	
	public String getPageTitle(){
		return PAGE_TITLE ;	
	}
	
	public void clickElement(WebElement element){
		element.click();
	}
	
	public void clickButtonChrome(WebElement element){
		element.sendKeys(Keys.ENTER);
	}

	public void setElementText(WebElement element , String text){
		element.clear();
		element.sendKeys(text);
		Assert.assertEquals(element.getAttribute("value"),text);
	}
	 
    public void selectValueInList(WebElement dropdown, String value){
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    
    public void selectTextInList(WebElement dropdown, String text){
    	dropdown.sendKeys(text);
    }
    
    public void clickRadioButton(WebElement element){
    	element.click();
    }  
    
    public String getPopupMsg(WebElement element){
 	   String message = element.getText();
 	   return message ;  
    }
    
   public String getValidationMsg(WebElement element) throws InterruptedException{
	   String message = element.getText();
	   return message ;   
    }
   
   
   public static String getProp(String type) throws IOException{
	   	File file = new File("src/test/resources/errors_arabic.arabicproperties");
//	   	File file = new File("src/test/resources/local.properties");
		FileInputStream fileInput =  new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String message = prop.getProperty(type);
		return new String(message.getBytes("ISO-8859-1"), "UTF-8");
	   }

	public void pickPreviousDate(WebElement openCalendar, WebElement navigateCurrentTitle, WebElement previousArrow, WebElement chooseYear, WebElement chooseMonth, WebElement chooseDay){
		openCalendar.click();
		navigateCurrentTitle.click();
		navigateCurrentTitle.click();
		previousArrow.click();
		chooseYear.click();
		chooseMonth.click();
		chooseDay.click();		
	}
  
	public void pickFutureDate(WebElement openCalendar, WebElement navigateCurrentTitle, WebElement nextArrow, WebElement chooseYear, WebElement chooseMonth, WebElement chooseDay){
		openCalendar.click();
		navigateCurrentTitle.click();
		navigateCurrentTitle.click();
		nextArrow.click();
		chooseYear.click();
		chooseMonth.click();
		chooseDay.click();		
	}
   
    public void scrollDown(WebElement element){
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
