package com.ecareers.pages;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.BasePage;

public class CareerFirstWizard extends BasePage {
	
	String firstName; 
	String secondName;
	String thirdName;
	String lastName;
	
	
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
	
	@FindBy(id = "firstName") WebElement validation_EmptyFirstName;
	@FindBy(id = "secondName") WebElement validation_EmptySecondName;
	@FindBy(id = "thirdName") WebElement validation_EmptyThirdName;
	@FindBy(id = "lastName") WebElement validation_EmptyLastName;
	@FindBy(id = "nationality") WebElement validation_EmptyNationality;
	@FindBy(id ="maritalStatus") WebElement validation_EmptyMaritalStatus;
	@FindBy(id ="birthPlace") WebElement validation_EmptyBirthPlace;
	@FindBy(id ="country") WebElement validation_EmptyCountry;
	@FindBy(id = "address") WebElement validation_EmptyAddress;
	@FindBy(id = "phoneNumber") WebElement validation_EmptyPhoneNumber;
	
	@FindBy(id = "birthDate") WebElement validation_WrongBirthDate;
	@FindBy(id = "phoneNumber") WebElement validation_WrongPhoneNumber;
	@FindBy(id = "fax") WebElement validation_WrongFax;
	@FindBy(id = "linkedin") WebElement validation_WrongLinkedIN;
	
	
		
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
		clickButtonChrome(button_Next);
	}
	
	
	public void fillNameInitials(String firstName , String secondName , String thirdName, String lastName) throws IOException{
		setText_FirstName(firstName);
		setText_SecondName(secondName);
		setText_ThirdName(thirdName);
		setText_LastName(lastName);
	}
	
	
	public void fillFlow(String firstName , String secondName , String thirdName, String lastName,
			String gender, String nationality, String maritalStatus, String birthPlace
			, String country , String address , String phoneNumber, String fax, String linkedinURL ) throws IOException{
	
		clickAddCareer();
		fillNameInitials(firstName,secondName,thirdName, lastName  );
		selectGender(gender);
		selectNationality(nationality);
		selectMaritalStatus(maritalStatus);
		selectBirthPlace(birthPlace);
		setText_BirthDate();
		selectCountry(country);
		setText_Address(address);
		setText_PhoneNumber(phoneNumber);
		setText_Fax(fax);
		setText_LinkedIN(linkedinURL);
		clickNext();
	}
}
