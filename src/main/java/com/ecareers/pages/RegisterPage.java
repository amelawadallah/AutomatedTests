package com.ecareers.pages;
import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.BasePage;
import com.google.common.base.CaseFormat;

public class RegisterPage extends BasePage{

	@FindBy(id = "firstName") WebElement field_FirstName;
	@FindBy(id = "lastName") WebElement field_LastName;
	@FindBy(name = "idType") WebElement dropDown_IdType;
	@FindBy(id = "idNumber") WebElement field_IdNumber;
	@FindBy(id = "email") WebElement field_RegisterEmail;
	@FindBy(id = "mobile") WebElement field_MobileNumber;
	@FindBy(id = "submitBtn") WebElement button_SignUp;
	@FindBy(id = "backBtn") WebElement button_Back;
	@FindBy(xpath = "//p") WebElement message_successRegistration;
	@FindBy(xpath = "//div[2]/button[2]") WebElement button_Accept;
	
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[2]/span") WebElement validation_EmptyFirstName;
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[3]/span") WebElement validation_EmptyLastName;
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[4]/span") WebElement validation_EmptyIdType;		
	
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[5]/span[1]") WebElement validation_EmptyIdNumber;		
	@FindBy(xpath="	.//*[@id='userMainDiv']/form/fieldset/div[2]/div[5]/span[2]") WebElement validation_RegisteredIdNumber;
	
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[6]/span[1]") WebElement validation_EmptyEmail;		
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[6]/span[2]") WebElement validation_WrongEmailFormat;		
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[6]/span[3]") WebElement validation_RegisteredEmail;
	
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[7]/span[2]") WebElement validation_EmptyMobileNumber;		
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[7]/span[3]") WebElement validation_WrongMobileNumber;
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[7]/span[4]") WebElement validation_RegisteredMobileNumber;		
	
	public RegisterPage(WebDriver driver){
		super(driver);
		this.PAGE_TITLE = "Jawwal Career" ;
		this.PAGE_URL = "http://10.102.5.244/ecareer/#/signup" ;
	}
	
	public void setText_FirstName(String text){
		setElementText(field_FirstName,text);
	}
	
	public void setText_LastName(String text){
		setElementText(field_LastName,text);
	}
	
	public void setText_IdNumber(String text){
		setElementText(field_IdNumber,text);
	}
	
	public void setText_RegisterEmail(String text){
		setElementText(field_RegisterEmail,text);
	}
	
	public void setText_MobileNumber(String text){
		setElementText(field_MobileNumber,text);
	}
	
	public void selectIdType(String value){
		selectValueInList(dropDown_IdType, value);
	}
	
	public void click_SignUp() throws InterruptedException{
		clickButtonChrome(button_SignUp);
		clickElement(button_SignUp);
	}
	
	public void click_Accept(){
		clickElement(button_Accept);
	}
	
	public void register(String firstName , String lastName, String idType, String idNumber, String email, String mobileNumber) throws InterruptedException  {
		Thread.sleep(100);
		setText_FirstName(firstName);
		setText_LastName(lastName);
		selectIdType(idType);
    	setText_IdNumber(idNumber);
    	setText_RegisterEmail(email);
    	setText_MobileNumber(mobileNumber);
    	click_SignUp();
    	Thread.sleep(100);
	}
	
	public void CheckSuccessfulRegistration() throws IOException, InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(message_successRegistration));
		Assert.assertEquals(getValidationMsg(message_successRegistration),getProp("successRegistration"));
    	click_Accept();
		
	}
	
	public void checkEmptyFieldsErrors(String errorType ) throws IOException, MessagingException, InterruptedException{
		switch(errorType){
		case "EmptyfieldsValidation":
			Assert.assertEquals( getValidationMsg(validation_EmptyFirstName),getProp("emptyFirstName") );
			Assert.assertEquals( getValidationMsg(validation_EmptyLastName),getProp("emptyLastName") );
			Assert.assertEquals( getValidationMsg(validation_EmptyIdType), getProp("emptyIdType"));	
			Assert.assertEquals( getValidationMsg(validation_EmptyIdNumber),getProp("emptyIdNumber"));
			Assert.assertEquals( getValidationMsg(validation_EmptyEmail), getProp("emptyEmail"));
			Assert.assertEquals( getValidationMsg(validation_EmptyMobileNumber),getProp("emptyMobileNumber") );
			break ;
		case "RegisteredUserData":
			Assert.assertEquals( getValidationMsg(validation_RegisteredIdNumber), getProp("registerdIdNumber"));
			Assert.assertEquals( getValidationMsg(validation_RegisteredEmail), getProp("registeredEmail"));
			Assert.assertEquals( getValidationMsg(validation_RegisteredMobileNumber), getProp("registeredMobileNumber"));
			break ;
		
		case "WrongFormats":
			Assert.assertEquals( getValidationMsg(validation_WrongEmailFormat), getProp("wrongEmailFormat"));
			Assert.assertEquals( getValidationMsg(validation_WrongMobileNumber), getProp("wrongMobileFormat"));
			break;
	
		}		
	}	
}
