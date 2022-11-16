package com.learnautomation.dataproviders;

import org.testng.annotations.DataProvider;

public class customDataProvider {
 
	@DataProvider(name="Login")
	public static Object[][] getLoginData(){
		return ExcelUtility.getDataFromSheet("login");
	}
	@DataProvider(name="IncorrectLogin")
	public static Object[][] getIncorrectLoginData(){
		return ExcelUtility.getDataFromSheet("incorrectlogin");
	}
}
