package com.ecareers.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.BasePage;

public class CareerSecondWizard extends BasePage {

	@FindBy(id ="jobTitle1") WebElement dropDown_JobTitle1;
	@FindBy(id ="jobTitle2") WebElement dropDown_JobTitle2;
	@FindBy(id ="jobTitle3") WebElement dropDown_JobTitle3;
	@FindBy(id = "workOutsideYes") WebElement yes_WorkOutside;
	@FindBy(id = "workOutsideNo") WebElement no_WorkOutside;
	@FindBy(id ="preferredStart") WebElement dropDown_StartDate;
	@FindBy(id = "hasRelativesYes") WebElement yes_HasRelatives;
	@FindBy(id = "hasRelativesNo") WebElement no_HasRelatives;
	@FindBy(id = "relativeName") WebElement field_RelativeName;
	@FindBy(id ="relativeType") WebElement dropDown_RelativeType;
	@FindBy(id = "interviewedInJawwalYes") WebElement yes_PreviouslyInterviewed;
	@FindBy(id = "interviewedInJawwalNo") WebElement no_PreviouslyInterviewed;
	@FindBy(id = "interviewJob") WebElement field_InterviewJob;
	@FindBy(id = "interviewDate") WebElement field_InterviewDate;
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Next;
	@FindBy(xpath="(//button[@type='button'])[21]") WebElement testDate;
	@FindBy(xpath=".//*[@id='interviewedInJawwalDetailsDiv']/div[2]/div/div/span/button") WebElement picktDate;
	
	@FindBy(xpath=".//div[@id='interviewedInJawwalDetailsDiv']/div[2]/div/div/span/button") WebElement iconCalendar;
	@FindBy(xpath="//div[@id='interviewedInJawwalDetailsDiv']/div[2]/div/div/ul/li/div/table/thead/tr/th[2]/button") WebElement calendarTitle;
	@FindBy(xpath="//div[@id='interviewedInJawwalDetailsDiv']/ul/li/div/table/thead/tr/th[3]/button") WebElement arrow_next;
	@FindBy(xpath="//div[@id='interviewedInJawwalDetailsDiv']/ul/li/div/table/thead/tr/th/button") WebElement arrow_previous;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthYear;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthMonth;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthDay;
	
	public CareerSecondWizard(WebDriver driver){
		super(driver);
		this.PAGE_TITLE="";
		this.PAGE_URL="";
	}
	
	public void selectJobTitle1(String value){
		selectValueInList(dropDown_JobTitle1, value);
	}
	
	public void selectJobTitle2(String value){
		selectValueInList(dropDown_JobTitle2, value);
	}
	
	public void selectJobTitle3(String value){
		selectValueInList(dropDown_JobTitle3, value);
	}
	
	public void setYes_WorkOutside(){
		clickElement(yes_WorkOutside);
		yes_WorkOutside.click();
	}

	public void setNO_WorkOutside(){
		clickElement(no_WorkOutside);
	}
	
	public void selectStartDate(String value){
		selectValueInList(dropDown_StartDate, value);
	}
	
	public void setYes_HasRelatives(){
		yes_HasRelatives.click();
		clickElement(yes_HasRelatives);
	}

	public void setNo_HasRelatives(){
		clickElement(no_HasRelatives);
	}
	
	public void setText_RelativeName(String text){
		setElementText(field_RelativeName,text);
	}
	
	public void selectRelativeType(String value){
		selectValueInList(dropDown_RelativeType, value);
	}
	
	public void setYes_PreviouslyInterviewed(){
		clickElement(yes_PreviouslyInterviewed);
	}
	
	public void setNO_PreviouslyInterviewed(){
		clickElement(no_PreviouslyInterviewed);
	}
	
	public void setText_InterviewJob(String text){
		setElementText(field_InterviewJob,text);
	}
	
	public void setText_InterviewDate(){
		pickPreviousDate(iconCalendar, calendarTitle, arrow_previous, birthYear, birthMonth, birthDay);
	}
	

	public void clickNext(){
		clickElement(button_Next);
	}
	
	public void fillFlow(){	
		selectJobTitle1("24");
		selectJobTitle2("23");
		selectJobTitle3("24");
		setYes_WorkOutside();
		selectStartDate("26");
		setYes_HasRelatives();
		wait.until(ExpectedConditions.elementToBeClickable(field_RelativeName));
		setText_RelativeName("Amer");
		selectRelativeType("304");
		setNO_PreviouslyInterviewed();
//		setYes_PreviouslyInterviewed();
//		setText_InterviewJob("Developer");
//		setText_InterviewDate();
		scrollDown(button_Next);
		clickNext();
	}
}
