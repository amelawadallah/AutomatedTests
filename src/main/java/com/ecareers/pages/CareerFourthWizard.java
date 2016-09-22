package com.ecareers.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.BasePage;

public class CareerFourthWizard extends BasePage {

	@FindBy(id="showAddExperienceFieldsBtn") WebElement button_AddWorkExperience;
	@FindBy(id="orgName") WebElement  field_OrgName;
	@FindBy(id="orgWorkCategory") WebElement field_OrgWorkCategory;
	@FindBy(id="orgCEOName") WebElement field_OrgCEOName;
	@FindBy(id="orgAddress") WebElement field_OrgAddress;
	@FindBy(id="orgPhone") WebElement field_OrgPhone;
	@FindBy(id="orgJob") WebElement field_JobPosition;
	@FindBy(id="orgStartDate") WebElement field_JobStartDate;
	@FindBy(id="orgEndDate") WebElement field_JobEndDate;
	@FindBy(id="orgSalary") WebElement field_Salary;
	@FindBy(id="orgCurrency") WebElement dropDown_Currency;
	@FindBy(id="addExperienceBtn") WebElement button_SubmitExperience;
	@FindBy(id="cancelEditExperienceBtn") WebElement button_CloseExperiencePopup;
	@FindBy(xpath="//table[@id='expTable']/tbody/tr/td[5]/a") WebElement icon_ShowMoreDetails;
	@FindBy(xpath="//table[@id='expTable']/tbody/tr/td[5]/a[2]/") WebElement icon_EditRow;
	@FindBy(xpath=".//*[@id='expTable']/tbody/tr[1]/td[5]/a[3]/") WebElement icon_Delete;
	
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Next;
	@FindBy(xpath=".//*[@id='keywords']") WebElement field_Tags;
	@FindBy(id="fakeBrowse") WebElement button_BrowseCV;
	@FindBy(xpath="//input[@id='fakeBrowse']") WebElement cv;
	@FindBy(xpath = "(//button[@type='button'])[4]") WebElement button_Accept;
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Finish;
	
	
	public CareerFourthWizard(WebDriver driver){
		super(driver);
		this.PAGE_TITLE = "";
		this.PAGE_URL = "";
	}
	
	public void click_AddWorkExperience(){
		clickElement(button_AddWorkExperience);
	}

	
	public void setText_OrgName(String text){
		setElementText(field_OrgName, text);
	}
	
	public void setText_OrgWorkCategory(String text){
		setElementText(field_OrgWorkCategory, text);
	}
	
	public void setText_OrgCEOName(String text){
		setElementText(field_OrgCEOName, text);
	}
	
	public void setText_OrgAddress(String text){
		setElementText(field_OrgAddress, text);
	}
	
	public void setText_OrgPhone(String text){
		setElementText(field_OrgPhone, text);
	}
	
	public void setText_JobPosition(String text){
		setElementText(field_JobPosition, text);
	}
	
	public void setText_Salary(String text){
		setElementText(field_Salary, text);
	}
	public void selectCurrency(String text){
		selectTextInList(dropDown_Currency, text);
	}
	
	public void click_SubmitExperience() {
		clickElement(button_SubmitExperience);
	}
	
	public void click_CloseExperiencePopup() {
		clickElement(button_CloseExperiencePopup);
	}
	
	public void click_Finish() {
		clickElement(button_Finish);
	}
	public void click_BrowserCV() {
		clickElement(button_BrowseCV);
	}	
	
	public void click_Accept(){
//		wait.until(ExpectedConditions.visibilityOf(button_Accept));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[4]")));
		clickElement(button_Accept);
	}
	public void addCV() throws AWTException{
////		click_BrowserCV();
		System.out.println("Displayed ==== " + button_BrowseCV.isDisplayed());
		System.out.println("Enabled ==== " + button_BrowseCV.isEnabled());
		System.out.println("Selected ==== " + button_BrowseCV.isSelected());
//		Actions action = new Actions(driver);
//		action.click(button_BrowseCV);
		wait.until(ExpectedConditions.elementToBeClickable(button_BrowseCV));		
		click_BrowserCV();
//		cv.click();	
		
		StringSelection s=new StringSelection("C:\\SoftwareJars\\Test1.docx");
//		StringSelection s=new StringSelection("C:\\Users\\vasadmin\\Desktop\\CVTEST.docx"); 
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
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void clickNext(){
		//clickElement(button_Next);
		clickButtonChrome(button_Next);
	}
	

	
	public void fillFlow() throws AWTException{
//		click_AddWorkExperience();
//		setText_OrgName("Asal");
//		setText_OrgWorkCategory("Software");
//		setText_OrgCEOName("Murad Tahbob");
//		setText_OrgAddress("Masyoon");
//		setText_OrgPhone("123654789");
//		setText_Salary("1000");
//		selectCurrency("JD");
		
		
	
		
//		 setText_Tags("automation");
		 addCV();
		 clickNext();
		 click_Accept();
		 
//		click_SubmitExperience();
		
		
	}
	
}
