package com.ecareers.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.BasePage;

public class ChangePasswordPage extends BasePage{
	String successMessage ;
	@FindBy(id = "currentPassword") WebElement field_OldPassword;
	@FindBy(id = "newPassword") WebElement field_NewPassword;
	@FindBy(id = "confirmPassword") WebElement field_ConfirmPassword;
	@FindBy(id = "submitbtn") WebElement button_ChangePassword;
	@FindBy(id = "backBtn") WebElement button_Back;
	@FindBy(id = "changePassDiv") WebElement navigate_ChangePassword;
	@FindBy(xpath="html/body/div[3]/div/div/div[2]/p") WebElement message_ChangePassword ; 
	
	public  ChangePasswordPage(WebDriver driver){
		super(driver) ; 
		this.PAGE_TITLE= "Jawwal Career";
		this.PAGE_URL= "http://10.102.5.244/ecareer/#/login";
	}
	
	public void setText_OldPassword(String text){
		setElementText(field_OldPassword,text);
	}
	
	public void setText_NewPassword(String text){
		setElementText(field_NewPassword,text);
	}
	
	public void setText_ConfirmPassword(String text){
		setElementText(field_ConfirmPassword,text);
	}
	
	public void click_ChangePassword(){
		clickElement(button_ChangePassword);	
	}
	
	public void navigate_ChangePassword(){
		clickElement(navigate_ChangePassword);	
	}
	
	public void changePassword(String oldPass, String newPass , String confirmPass )throws InterruptedException {
		navigate_ChangePassword() ;
		setText_OldPassword(oldPass);
		setText_NewPassword(newPass);
		setText_ConfirmPassword(confirmPass);
		click_ChangePassword();
		successMessage  = message_ChangePassword.getText(); 
		Assert.assertEquals(successMessage, "تم تغيير كلمة المرور بنجاح");
		System.out.println("Password update successfully "+ successMessage );
	}

}
