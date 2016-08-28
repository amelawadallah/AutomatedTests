package com;
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
   
    public void scrollDown(){
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("scroll(0, 250)");
    }
}
