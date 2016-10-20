package com.ecareers.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.BasePage;

public class Convert2Career extends BasePage {
	
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
	@FindBy(xpath = ".//*[@id='appTable']/tbody/tr/td[4]/span/a") WebElement button_Convert2Career;
	@FindBy(xpath = "//div[2]/button") WebElement button_YesConvert;
	@FindBy(xpath = "//button[3]") WebElement button_NoConvert;
	@FindBy(xpath = "//div[@id='careerNextBtnDiv']/button") WebElement button_Next;
	@FindBy(xpath=".//*[@id='appWizard']/div/section/fieldset[1]/div[8]/div/span[1]/button") WebElement iconCalendar;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th[2]/button") WebElement calendarTitle;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th[3]/button") WebElement arrow_next;
	@FindBy(xpath="//div[@id='birthDateDiv']/ul/li/div/table/thead/tr/th/button") WebElement arrow_previous;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthYear;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthMonth;
	@FindBy(xpath="(//button[@type='button'])[5]") WebElement birthDay;
		   
	public Convert2Career(WebDriver driver){
		super(driver);
		this.PAGE_TITLE="Jawwal Career";
		this.PAGE_URL="http://10.102.5.244/ecareer/#/home";
	}

	public void clickConvert2Career(){
		wait.until(ExpectedConditions.elementToBeClickable(button_Convert2Career));
		clickElement(button_Convert2Career);
	}
	
	public String getCurrentAppType(){
		String appType;
		appType =button_Convert2Career.getText();
		return appType;
	}
	
	public void clickCancelConvert(){
		clickElement(button_NoConvert);
	}
	
	public void clickProceedConvert(){
		wait.until(ExpectedConditions.elementToBeClickable(button_YesConvert));
		clickElement(button_YesConvert);
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
	
	public void fillFlow() throws InterruptedException{
		clickConvert2Career();
		Thread.sleep(1000);
		clickProceedConvert();
		Thread.sleep(1000);
		clickProceedConvert();
	}
}
