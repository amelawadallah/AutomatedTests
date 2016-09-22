package com.ecareers.data;
import org.testng.annotations.DataProvider;

public class TestData{

	//args are urls and titles
	@DataProvider(name = "websites")
	public  Object[][] pages(){
		return new Object[][]{
				{"https://ecareer.jawwal.ps", "Palestine Cellular Communication LTD Jawwal - Job Application Form - Wellcome"},
				{"https://www.google.com", "Google"},
				{"https://www.facebook.com", "Facebook - Log In or Sign Up"}
		};
	}
	
	
	
	@DataProvider(name = "registerData")
	public static Object [][] registerData(){
		return new Object[][]{
				{"noor", "test", "2", "18224879633", "noor@testjawwal.com", "0598121878"},
		};
	}
	
	@DataProvider(name = "changePasswordData")
	public static Object [][] changePasswordData(){
		return new Object[][]{
				{"noor@testjawwal.com","123456", "123456", "123456"}
		};
	}
}
