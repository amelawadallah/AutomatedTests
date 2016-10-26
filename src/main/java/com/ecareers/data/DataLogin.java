package com.ecareers.data;

import org.testng.annotations.DataProvider;

public class TestLoginData {

	@DataProvider(name = "loginData")
	public  static Object[][] loginData(){
		return new Object[][]{
				{"samer@testjawwal.com", "123456", "No errors"},		
		};
	}
	
	@DataProvider(name = "wrongLoginData")
	public  static Object[][] wrongLoginData(){
		return new Object[][]{
				{"dummy@dummy.com", "123456", "WrongCredentials"},
		};
	}
	
	@DataProvider(name = "loginDataValidation")
	public  static Object[][] loginDataValidation(){
		return new Object[][]{
				{"","123456","EmptyEmailValidation"},
				{"amel@testjawwal.com","","EmptyPasswordValidation"},
				{"a", "1", "EmailFormatValidation" },
				};
	}
}
