package com.ecareers.pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.MessagingException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.BasePage;

public class LoginPage extends  BasePage{
	
	@FindBy(id = "username") WebElement field_EmailLogin;
	@FindBy(id = "password") WebElement field_PasswordLogin;
	@FindBy(id = "submitBtn") WebElement button_Login;
	@FindBy(id = "logoutDiv") public  WebElement button_Accept;
	@FindBy(xpath = "//button[2]") WebElement button_CloseError;
	@FindBy(xpath= "//div[3]/div/div/div[1]/p")  WebElement popup_LoginError;
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[1]/span[1]") WebElement validation_EmptyEmail;
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[2]/span") WebElement validation_EmptyPassword;
	@FindBy(xpath=".//*[@id='userMainDiv']/form/fieldset/div[2]/div[1]/span[2]") WebElement validation_WrongEmailFormat;
	public LoginPage(WebDriver driver){
		super(driver) ;
		this.PAGE_TITLE = "Jawwal Career" ;
		this.PAGE_URL = "http://10.102.5.244/ecareer/#/login" ;
	}
	
	public void setText_Email(String text){
		setElementText(field_EmailLogin,text);
	}
	
	public void setText_Password(String text){
		setElementText(field_PasswordLogin,text);
	}
	
	public void loginToProfile(String email, String password){
		wait.until(ExpectedConditions.elementToBeClickable(field_EmailLogin));
		setText_Email(email);
		setText_Password(password);
		clickElement(button_Login);
	}
		


	public void checkErrorsswitch(String errorType) throws IOException, MessagingException{
		switch(errorType){
		case "EmptyEmailValidation":
			System.out.println(getProp("emptyEmail_validation"));
			Assert.assertEquals( getValidationMsg(validation_EmptyEmail), getProp("emptyEmail"));
			break ;
		case "EmptyPasswordValidation":
			Assert.assertEquals( getValidationMsg(validation_EmptyPassword), getProp("emptyPassword"));
			break ;
		case "WrongCredentials":
			Assert.assertEquals( getPopupMsg(popup_LoginError) , getProp("wrongCredentials"));
			clickElement(button_CloseError);
			break ;
		case  "EmailFormatValidation":
			Assert.assertEquals(getValidationMsg(validation_WrongEmailFormat), getProp("wrongEmailFormat"));
			break ;
		default:
			Assert.assertTrue(button_Accept.isDisplayed());
		}		
	}	
}
