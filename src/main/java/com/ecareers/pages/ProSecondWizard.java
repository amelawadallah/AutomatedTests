package com.ecareers.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.BasePage;

public class ProSecondWizard extends BasePage{
	
	@FindBy(id = "degree") WebElement dropDown_Degree;
	@FindBy(id = "institution") WebElement dropDown_Institution;
	@FindBy(id = "major") WebElement dropDown_Major;
	@FindBy(id ="appreciation") WebElement dropDown_Appreciation;
	@FindBy(id = "gpa") WebElement field_GPA;
	@FindBy(id = "relocateToDifferentCitiesYes") WebElement yes_Relocate;
	@FindBy(id = "relocateToDifferentCitiesNo") WebElement no_Relocate;
	@FindBy(id = "changeResidenceYes") WebElement yes_ChangeResidence;
	@FindBy(id = "changeResidenceNo") WebElement no_ChangeResidence;	
	@FindBy(id = "interviewedInJawwalYes") WebElement yes_PreviouslyInterviewed;
	@FindBy(id = "interviewedInJawwalNo") WebElement no_PreviouslyInterviewed;
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Next;
	@FindBy(xpath="(//button[@type='button'])[21]") WebElement testDate;
	@FindBy(xpath=".//*[@id='appWizard']/div/section/fieldset[1]/div[7]/div/span[1]/button") WebElement picktDate;
	@FindBy(xpath="//div[@id='appWizard']/div/section/fieldset/div[7]/div/span/button") WebElement iconCalendar;
	@FindBy(xpath="//div[@id='appWizard']/div/section/fieldset/div[7]/div/ul/li/div/table/thead/tr/th[2]/button") WebElement calendarTitle;
	@FindBy(xpath="//div[@id='appWizard']/div/section/fieldset/div[7]/div/ul/li/div/table/thead/tr/th[3]/button") WebElement arrow_next;
	@FindBy(xpath="//div[@id='appWizard']/div/section/fieldset/div[7]/div/ul/li/div/table/thead/tr/th/button") WebElement arrow_previous;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthYear;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthMonth;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthDay;
	
	
	public ProSecondWizard(WebDriver driver){
		super(driver);
		this.PAGE_TITLE = "";
		this.PAGE_URL = "";
	}
	
	public void selectDegree(String text){
		selectTextInList(dropDown_Degree, text);
	}
	
	public void selectInstitution(String text){
		selectTextInList(dropDown_Institution, text);
	}

	public void selectMajor(String text){
		selectTextInList(dropDown_Major, text);
	}
	
	public void selectApprecication(String text){
		selectTextInList(dropDown_Appreciation, text);
	}
	
	public void setText_GPA(String text){
		setElementText(field_GPA, text);
	}
	
	public void setYes_Relocate(){
		yes_Relocate.click();
		clickElement(yes_Relocate);
	}

	public void setNo_Relocate(){
		clickElement(no_Relocate);
	}
	
	public void setYes_Residence(){
		clickElement(yes_ChangeResidence);
	}
	
	public void setNO_Residence(){
		clickElement(no_ChangeResidence);
	}
	
	public void setYes_PreviouslyInterviewed(){
		clickElement(yes_PreviouslyInterviewed);
	}
	
	public void setNO_PreviouslyInterviewed(){
		clickElement(no_PreviouslyInterviewed);
	}
	
	public void clickNext(){
		clickButtonChrome(button_Next);
	}
	
	public void fillFlow(){
		selectDegree("بكالوريوس");
		selectInstitution("كلية الامه");
		selectMajor("هندسة انظمة الحاسوب");
		selectApprecication("جيد جدا");
		setText_GPA("5");
		setYes_PreviouslyInterviewed();
		setYes_Relocate();
		setYes_Residence();
		clickNext();
	}

}

