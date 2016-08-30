package com;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thoughtworks.selenium.webdriven.commands.Click;
import com.thoughtworks.selenium.webdriven.commands.ClickAt;

public class BasePage{

	public WebDriver driver; 
	public WebDriverWait wait;
	public String PAGE_URL;
	public String PAGE_TITLE;
	
	public BasePage(WebDriver driver){
		this.driver = driver ;
		wait = new WebDriverWait(driver, 5);
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
    
   public String getValidationMsg(WebElement element){
	   String message = element.getText();
	   return message ;   
   }
   

   
    public void scrollDown(WebElement element){
//    	JavascriptExecutor jse = (JavascriptExecutor)driver;
//    	jse.executeScript("scroll(0, 250)");
//    	WebElement element = driver.findElement(By.id("id_of_element"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
   
    }
}
