package com.ecareers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.BasePage;

public class CareerThirdWizard extends BasePage{
	
	@FindBy(id = "degree") WebElement dropDown_Degree;
	@FindBy(id = "institution") WebElement dropDown_Institution;
	@FindBy(id = "college") WebElement dropDown_College;
	@FindBy(id = "major") WebElement dropDown_Major;
	@FindBy(id = "minor") WebElement dropDown_Minor;
	@FindBy(id ="institutionCountry") WebElement dropDown_InstitutionCountry;
	@FindBy(id ="appreciation") WebElement dropDown_Appreciation;
	@FindBy(id = "graduationDate") WebElement field_GraduationDate;
	@FindBy(id = "gpa") WebElement field_GPA;
	@FindBy(id ="arabicLanguage") WebElement dropDown_ArabicLanguage;
	@FindBy(id ="englishLanguage") WebElement dropDown_EnglishLanguage;
	@FindBy(id ="otherLanguage") WebElement dropDown_OtherLanguage;
	@FindBy(id = "otherLanguageText") WebElement field_OtherLanguageText;
	@FindBy(id ="otherLanguageLevel") WebElement dropDown_OtherLanguageLevel;
	@FindBy(id = "haveDrivingLicenseYes") WebElement yes_DrivingLicense;
	@FindBy(id = "haveDrivingLicenseNo") WebElement no_DrivingLicense;
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Next;
	@FindBy(xpath="(//button[@type='button'])[21]") WebElement testDate;
	@FindBy(xpath=".//*[@id='appWizard']/div/section/fieldset[1]/div[7]/div/span[1]/button") WebElement picktDate;

	@FindBy(xpath=".//*[@id='appWizard']/div/section/fieldset[1]/div[8]/div/span[1]/button") WebElement iconCalendar;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th[2]/button") WebElement calendarTitle;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th[3]/button") WebElement arrow_next;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th/button") WebElement arrow_previous;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthYear;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthMonth;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthDay;
	
	
	public CareerThirdWizard(WebDriver driver){
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
	
	public void selectCollege(String text){
		selectTextInList(dropDown_College, text);
	}
	
	public void selectMajor(String text){
		selectTextInList(dropDown_Major, text);
	}
	
	public void selectMinor(String text){
		selectTextInList(dropDown_Minor, text);
	}
	
	public void selectInstitutionCountry(String text){
		selectTextInList(dropDown_InstitutionCountry, text);
	}
	
	public void selectApprecication(String text){
		selectTextInList(dropDown_Appreciation, text);
	}
	
	public void setText_GraduationDate(){
		pickPreviousDate(iconCalendar, calendarTitle, arrow_previous, birthYear, birthMonth, birthDay);
	}
	
	public void setText_GPA(String text){
		setElementText(field_GPA, text);
	}
	
	public void selectArabicLangLevel(String text){
		selectTextInList(dropDown_ArabicLanguage, text);
	}
	
	public void selectEngLangLevel(String text){
		selectTextInList(dropDown_EnglishLanguage, text);
	}
	
	public void selectOtherLanguages(String text){
		selectTextInList(dropDown_OtherLanguage,text);
	}
	
	public void setText_OtherLanguage(String text){
		setElementText(field_OtherLanguageText, text);
	}
	
	public void selectOtherLangLevel(String text){
		selectTextInList(dropDown_OtherLanguageLevel, text);
	}
	
	public void setYes_DrivingLicense(){
		yes_DrivingLicense.click();
		clickElement(yes_DrivingLicense);
	}

	public void setNo_DrivingLicense(){
		clickElement(no_DrivingLicense);
	}
	
	public void clickNext(){
		clickElement(button_Next);
	}
	
	public void fillFlow(){
		selectDegree("بكالوريوس");
		selectInstitution("كلية الامه");
		selectCollege("الهندسة");
		selectMajor("هندسة انظمة الحاسوب");
		selectMinor("ادارة اعمال");
		selectInstitutionCountry("النمسا");
		setText_GraduationDate();
		selectApprecication("جيد جدا");
		setText_GPA("5");
		selectArabicLangLevel("متمرس");
		selectEngLangLevel("متمرس");
		selectOtherLanguages("أخرى");
		selectOtherLangLevel("متمرس");
		setText_OtherLanguage("armen");
		
		setYes_DrivingLicense();
		clickNext();
	}

}

