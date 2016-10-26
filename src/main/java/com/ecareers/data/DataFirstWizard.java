package com.ecareers.data;

import org.testng.annotations.DataProvider;

public class TestFirstWizard {

	
	@DataProvider(name = "CorrectData")
	public static Object [][] CorrectData(){
		return new Object[][]{
				{"Noor", "Mohammad", "Ali", "Dawood", "ذكر", "فلسطيني", "أعزب\\عزباء", "الإمارات العربية المتحدة"
					, "سوريا",  "Street101", "02290000","02900001","https://www.linkedin.com/in/amel-awadallah-47579227" },
//			   
		};
	}
	
	@DataProvider(name = "WrongFormats")
	public  static Object[][] WrongFormats(){
		return new Object[][]{
						{"Noor", "Mohammad", "Ali", "Dawood", "ذكر", "فلسطيني", "أعزب\\عزباء",
						"الإمارات العربية المتحدة", "فلسطين", "رام الله", "Street101",
						"02290","0290","linkedi" } ,
							
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
				{"", "", "", "", "", "", "",
					"", "", "", "",
					"","","" } ,
	};
	}
}
