package com.ecareers.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.BasePage;

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
		Thread.sleep(5000);
		setText_FirstName(firstName);
		setText_LastName(lastName);
		selectIdType(idType);
    	setText_IdNumber(idNumber);
    	setText_RegisterEmail(email);
    	setText_MobileNumber(mobileNumber);
    	click_SignUp();
    	wait.until(ExpectedConditions.visibilityOf(message_successRegistration));
    	Assert.assertEquals(message_successRegistration.getText(),"تمت عملية التسجيل بنجاح . لقد تم ارسال كلمة المرور الى بريدك الالكتروني كما وتم إرسال رسالة نصية قصيرة إلى هاتفك المحمول\n\nوشكراً");
    	System.out.println(message_successRegistration.getText());
    	click_Accept();
	}
}
