package com.ecareers.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	@FindBy(id="fakeBrowse") WebElement button_BrowseCV;
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
	
	public void addCV() throws AWTException{
		click_BrowserCV();
		StringSelection ss = new StringSelection("C:/SoftwareJars/Test1.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
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
		addCV();
		click_SubmitExperience();
		
		
	}
	
}
