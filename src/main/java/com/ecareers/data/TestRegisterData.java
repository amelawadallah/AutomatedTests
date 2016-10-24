package com.ecareers.data;

import org.testng.annotations.DataProvider;

public class TestRegisterData {

	
	@DataProvider(name = "RegisterData")
	public static Object [][] RegisterData(){
		return new Object[][]{
				{"Amel", "Awadallah", "2", "12233", "amal.awadallah@jawwal.ps", "598024977"},
//			    {"Reem", "test", "2", "18222243875633", "amel.awadallah@gmail.com", "0598024977"}
		};
	}
	
	@DataProvider(name = "WrongFormats")
	public  static Object[][] WrongFormats(){
		return new Object[][]{
				{"Amel", "Awadallah", "2", "1223344", "a23", "123", "WrongFormats"},
		};
	}
	
	@DataProvider(name = "RegisteredUserData")
	public  static Object[][] RegisteredUserData(){
		return new Object[][]{
				{"RegisteredUserData"}
		};
	}
	
	@DataProvider(name = "EmptyfieldsValidation")
	public  static Object[][] EmptyfieldsValidation(){
		return new Object[][]{
				{"", "", "", "", "", "","EmptyfieldsValidation"},
				};
	}
}
