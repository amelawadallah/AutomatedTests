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
		
	@FindBy(xpath=".//*[@id='expFieldsDiv']/div[2]/div[3]/div/span/button") WebElement iconCalendarStart;
	@FindBy(xpath="//th[2]/button") WebElement calendarTitleStart;
	@FindBy(xpath="//th[3]/button") WebElement arrow_nextStart;
	@FindBy(xpath="//th/button") WebElement arrow_previousStart;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthYearStart;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthMonthStart;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthDayStart;
	
	@FindBy(xpath=".//*[@id='expFieldsDiv']/div[2]/div[4]/div/span/button") WebElement iconCalendarEnd;
	@FindBy(xpath="//div[4]/div/ul/li/div/table/thead/tr/th[2]/button") WebElement calendarTitleEnd;
	@FindBy(xpath="//div[4]/div/ul/li/div/table/thead/tr/th[3]/button") WebElement arrow_nextEnd;
	@FindBy(xpath="//div[4]/div/ul/li/div/table/thead/tr/th/button") WebElement arrow_previousEnd;
	@FindBy(xpath="//div[4]/div/ul/li/div/table/tbody/tr[4]/td[3]/button") WebElement birthYearEnd;
	@FindBy(xpath="//div[4]/div/ul/li/div/table/tbody/tr[4]/td[3]/button") WebElement birthMonthEnd;
	@FindBy(xpath="//div[4]/div/ul/li/div/table/tbody/tr[4]/td[3]/button") WebElement birthDayEnd;
		
	@FindBy(name ="ref1FullName") WebElement field_refNameFirst;
	@FindBy(name ="ref1Job") WebElement field_refJobFirst;
	@FindBy(name ="ref1Address") WebElement field_refAddressFirst;
	@FindBy(name ="ref1Phone") WebElement field_refPhoneFirst;
	
	@FindBy(name="ref2FullName") WebElement field_refNameSecond;
	@FindBy(name="ref2Job") WebElement field_refJobSecond;
	@FindBy(name="ref2Address") WebElement field_refAddressSecond;
	@FindBy(name="ref2Phone") WebElement field_refPhoneSecond;
	
	@FindBy(name="ref3FullName") WebElement field_refNameThird;
	@FindBy(name="ref3Job") WebElement field_refJobThird;
	@FindBy(name="ref3Address") WebElement field_refAddressThird;
	@FindBy(name="ref3Phone") WebElement field_refPhoneThird;
	
	public CareerFourthWizard(WebDriver driver){
		super(driver);
		this.PAGE_TITLE = "";
		this.PAGE_URL = "";
	}
	
	public void click_AddWorkExperience() throws InterruptedException{
		if(button_AddWorkExperience.isDisplayed()&& button_AddWorkExperience.isEnabled())
		{
		 wait.until(ExpectedConditions.elementToBeClickable(button_AddWorkExperience));
		clickElement(button_AddWorkExperience);
		}else{
			System.out.println("Add Experience button is not enabled");
		}
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
	
	public void setText_StartDate(){
		pickPreviousDate(iconCalendarStart, calendarTitleStart, arrow_previousStart, birthYearStart, birthMonthStart, birthDayStart);
	}
	
	public void setText_EndDate(){
		pickPreviousDate(iconCalendarEnd, calendarTitleEnd, arrow_previousEnd, birthYearEnd, birthMonthEnd, birthDayEnd);
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
	
	public void setText_RefName1(String text){
		setElementText(field_refNameFirst, text);
	}
	
	
	public void setText_RefJob1(String text){
		setElementText(field_refJobFirst, text);
	}
	
	
	public void setText_RefAddress1(String text){
		setElementText(field_refAddressFirst, text);
	}
	
	public void setText_RefPhone1(String text){
		setElementText(field_refPhoneFirst, text);
	}
	
	
	public void setText_RefName2(String text){
		setElementText(field_refNameSecond, text);
	}
	
	
	public void setText_RefJob2(String text){
		setElementText(field_refJobSecond, text);
	}
	
	
	public void setText_RefAddress2(String text){
		setElementText(field_refAddressSecond, text);
	}
	
	public void setText_RefPhone2(String text){
		setElementText(field_refPhoneSecond, text);
	}
	
	public void setText_RefName3(String text){
		setElementText(field_refNameThird, text);
	}
	
	
	public void setText_RefJob3(String text){
		setElementText(field_refJobThird, text);
	}
	
	
	public void setText_RefAddress3(String text){
		setElementText(field_refAddressThird, text);
	}
	
	public void setText_RefPhone3(String text){
		setElementText(field_refPhoneThird, text);
	}
	
	public void click_Finish() {
		clickElement(button_Finish);
	}
	public void click_BrowserCV() {
		clickElement(button_BrowseCV);
	}	
	
	public void click_Accept(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[4]")));
		clickElement(button_Accept);
	}
	
	public void clickNext(){
		clickButtonChrome(button_Next);
	}
	
	public void addExperienceFlow(String orgName, String workCategory, String CEOname, String address ,
		String phoneNumber, String jobPosition, String salary , String currency) throws InterruptedException{
		 
		click_AddWorkExperience();
		setText_OrgName(orgName);
		setText_OrgWorkCategory(workCategory);
		setText_OrgCEOName(CEOname);
		setText_OrgAddress(address);
		setText_OrgPhone(phoneNumber);
		setText_JobPosition(jobPosition);
		setText_StartDate();
		setText_EndDate();
		setText_Salary(salary);
		selectCurrency(currency);	
		click_SubmitExperience() ; 
	 }
	 
		
	 public void addRefernce(String name , String jobPosition , String address, String phoneNumber){
		setText_RefName1(name);
		setText_RefJob1(jobPosition);
		setText_RefAddress1(address);
		setText_RefPhone1(phoneNumber);
	 }
		
	 public void addRefernce2(String name , String jobPosition , String address, String phoneNumber){
		setText_RefName2(name);
		setText_RefJob2(jobPosition);
		setText_RefAddress2(address);
		setText_RefPhone2(phoneNumber);
	 }
	 
	 public void addRefernce3(String name , String jobPosition , String address, String phoneNumber){
		setText_RefName3(name);
		setText_RefJob3(jobPosition);
		setText_RefAddress3(address);
		setText_RefPhone3(phoneNumber);
	 }
		
	
	public void setText_Tags(String text) throws AWTException{
		System.out.println("tagsisclickable............" + field_Tags.isEnabled());
		System.out.println("tagsatt............" + field_Tags.getAttribute("text"));
		System.out.println("tagsvalue............" + field_Tags.getAttribute("value"));
		System.out.println("tagsname............" + field_Tags.getAttribute("name"));
		System.out.println("tagsid............" + field_Tags.getAttribute("id"));
		System.out.println("getText............" + field_Tags.getText());
		System.out.println("getTagName............" + field_Tags.getTagName());
		field_Tags.sendKeys(text);
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
	
	public void fillFlow() throws AWTException, InterruptedException{	
		addExperienceFlow("asal" , "softwrae", "Murad", "ramallah", "022966640", "CEO", "2010", "JD");
		addExperienceFlow("jawwal" , "telecommunications", "Omar", "ramallah", "02296550", "CEO", "20100", "JD");	
		addRefernce("iman","manager", "ramallah", "123654789");
//		addRefernce2("iman","manager", "ramallah", "123654789");
//		addRefernce3("iman","manager", "ramallah", "123654789");
		addCV();
		clickNext();
		click_Accept();
	}
	
}
