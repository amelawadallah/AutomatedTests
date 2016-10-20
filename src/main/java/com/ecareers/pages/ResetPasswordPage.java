package com.ecareers.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.BasePage;

public class ResetPasswordPage extends BasePage{

	@FindBy(id = "email") WebElement field_ResetEmail;
	@FindBy(id = "phoneNumber") WebElement field_ResetMobile;
	@FindBy(id = "emailResetOpt") WebElement radio_ResetEmail;
	@FindBy(id = "smsResetOpt") WebElement radio_ResetMobile;
	@FindBy(id = "submitbtn") WebElement button_Reset;
	@FindBy(id = "backBtn") WebElement button_Back;
	
	public ResetPasswordPage(WebDriver driver){
		super(driver);	
		this.PAGE_TITLE="Jawwal Career";
		this.PAGE_URL= "http://10.102.5.244/ecareer/#/resetPass";
	}
	
	public void setText_ResetEmail(String text){
		setElementText(field_ResetEmail,text);	
	}
	
	public void setText_ResetMobile(String text){
		setElementText(field_ResetMobile,text);
	}

	public void clickReset(){
		clickElement(button_Reset);	
	}
	
	public void resetByEmail(){
		setText_ResetEmail("amal.awadallah@jawwal.ps");
		clickReset();
	}

	public void resetBySMS(){
		radio_ResetMobile.click();
		setText_ResetMobile("05997877878");
		clickReset();
	}
}
