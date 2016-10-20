package com.ecareers.pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.BasePage;

public class ProThirdWizard extends BasePage {
	
	@FindBy(id="goProReason") WebElement  field_ProReason;
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Next;
	@FindBy(xpath=".//*[@id='keywords']") WebElement field_Tags;
	@FindBy(id="fakeBrowse") WebElement button_BrowseCV;
	@FindBy(xpath="//input[@id='fakeBrowse']") WebElement cv;
	@FindBy(xpath = "html/body/div[3]/div/div/div[2]/button[2]") WebElement button_Accept;
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Finish;

	public ProThirdWizard(WebDriver driver){
		super(driver);
		this.PAGE_TITLE = "";
		this.PAGE_URL = "";
	}
		
	public void setText_GoProReason(String text){
		setElementText(field_ProReason, text);
	}
		
	public void click_Finish() {
		clickElement(button_Finish);
	}
	
	public void click_BrowserCV() {
		clickElement(button_BrowseCV);
	}	
	
	public void click_Accept(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div/div/div[2]/button[2]")));
		clickElement(button_Accept);
	}
	
	public void clickNext(){
		clickButtonChrome(button_Next);
	}
	
	public void addCV() throws AWTException{
		wait.until(ExpectedConditions.elementToBeClickable(button_BrowseCV));		
		click_BrowserCV();
		StringSelection s=new StringSelection("C:\\SoftwareJars\\Ahmad_Shawar_CV.docx"); 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null); 
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		click_Accept();
			
	}
	
	public void setText_Tags(String text) throws AWTException{
	//	setElementText(field_Tags, text);
		System.out.println("tagsisclickable............" + field_Tags.isEnabled());
		System.out.println("tagsatt............" + field_Tags.getAttribute("text"));
		System.out.println("tagsvalue............" + field_Tags.getAttribute("value"));
		System.out.println("tagsname............" + field_Tags.getAttribute("name"));
		System.out.println("tagsid............" + field_Tags.getAttribute("id"));
		System.out.println("getText............" + field_Tags.getText());
		System.out.println("getTagName............" + field_Tags.getTagName());
		field_Tags.sendKeys(text);
//		Robot robot=new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);	
	}

	public void fillFlow() throws AWTException, InterruptedException{		
		setText_GoProReason("I want to join JAwwal ");
		addCV();
		clickNext();
		click_Accept();
	}
}
