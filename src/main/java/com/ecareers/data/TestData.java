package com.ecareers.data;
import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.annotations.DataProvider;
import com.ecareers.pages.CheckEmail;

public class TestData{

	@DataProvider(name = "websites")
	public  Object[][] pages(){
		return new Object[][]{
				{"https://ecareer.jawwal.ps", "Palestine Cellular Communication LTD Jawwal - Job Application Form - Wellcome"},
				{"https://www.google.com", "Google"},
				{"https://www.facebook.com", "Facebook - Log In or Sign Up"}
		};
	}
	

	
	@DataProvider(name = "changePasswordData")
	public static Object [][] changePasswordData() throws MessagingException, IOException{
		CheckEmail checkEmail = new CheckEmail();
		String password = checkEmail.getPassword();
		return new Object[][]{
				{"sari@testjawwal.com","123456", "123456", "123456"}
		};
	}
}
