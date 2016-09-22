package com.ecareers.pages;
import com.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareerFirstWizard extends BasePage {
	
	@FindBy(id = "firstName") WebElement field_FirstName;
	@FindBy(id = "secondName") WebElement field_SecondName;
	@FindBy(id = "thirdName") WebElement field_ThirdName;
	@FindBy(id = "lastName") WebElement field_LastName;
	@FindBy(id = "gender") WebElement dropDown_Gender;
	@FindBy(id = "nationality") WebElement dropDown_Nationality;
	@FindBy(id ="maritalStatus") WebElement dropDown_MaritalStatus;
	@FindBy(id ="birthPlace") WebElement dropDown_BirthPlace;
	@FindBy(id = "birthDate") WebElement field_BirthDate;
	@FindBy(id ="country") WebElement dropDown_Country;
	@FindBy(id = "address") WebElement field_Address;
	@FindBy(id = "phoneNumber") WebElement field_PhoneNumber;
	@FindBy(id = "fax") WebElement field_Fax;
	@FindBy(id = "linkedin") WebElement field_LinkedIN;
	@FindBy(id = "addCareerBtn") WebElement button_AddCareerApp;
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Next;
	
	@FindBy(xpath=".//*[@id='appWizard']/div/section/fieldset[1]/div[8]/div/span[1]/button") WebElement iconCalendar;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th[2]/button") WebElement calendarTitle;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th[3]/button") WebElement arrow_next;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th/button") WebElement arrow_previous;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthYear;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthMonth;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthDay;
	
	
	


			   
		
   
	public CareerFirstWizard(WebDriver driver){
		super(driver);
		this.PAGE_TITLE="Jawwal Career";
		this.PAGE_URL="http://10.102.5.244/ecareer/#/career";
	}

	public void clickAddCareer(){
		wait.until(ExpectedConditions.elementToBeClickable(button_AddCareerApp));
		clickElement(button_AddCareerApp);
	}
	
	public void setText_FirstName(String text){
		setElementText(field_FirstName,text);
	}
	
	public void setText_SecondName(String text){
		setElementText(field_SecondName,text);
	}
	
	public void setText_ThirdName(String text){
		setElementText(field_ThirdName,text);
	}
	
	public void setText_LastName(String text){
		setElementText(field_LastName,text);
	}
	
	public void selectGender(String value){
//		dropDown_Gender.sendKeys("أنثى");
		selectValueInList(dropDown_Gender, value);
	}

	public void selectNationality(String value){
		selectValueInList(dropDown_Nationality, value);
	
	}
	
	public void selectMaritalStatus(String value){
		selectValueInList(dropDown_MaritalStatus, value);
	}
	
	public void selectBirthPlace(String value){
		selectValueInList(dropDown_BirthPlace, value);
	}
	
	public void setText_BirthDate(){
		pickPreviousDate(iconCalendar, calendarTitle, arrow_previous, birthYear, birthMonth, birthDay);
	}
	
	public void selectCountry(String value){
		selectValueInList(dropDown_Country, value);
	}
	
	public void setText_Address(String text){
		setElementText(field_Address,text);
	}
	
	public void setText_PhoneNumber(String text){
		setElementText(field_PhoneNumber,text);
	}
	
	public void setText_Fax(String text){
		setElementText(field_Fax,text);
	}
	
	public void setText_LinkedIN(String text){
		setElementText(field_LinkedIN,text);
	}
	
	public void clickNext(){
		//clickElement(button_Next);
		clickButtonChrome(button_Next);
	}
	
	public void fillFlow(){
		clickAddCareer();
		setText_FirstName("samer");
		setText_SecondName("name");
		setText_ThirdName("middle");
		setText_LastName("test");
		selectGender("13");
		selectNationality("14");
		selectMaritalStatus("16");
		selectBirthPlace("191");
		setText_BirthDate();
		selectCountry("191");
		setText_Address("ramallah");
		setText_PhoneNumber("022892959");
		setText_Fax("022654789");
		setText_LinkedIN("https://www.linkedin.com/in/amel-awadallah-47579227");
		clickNext();
		
		
	}
}
