package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginbtn = By.id("login-button");
	
	
	public void enterusername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	public void enterpassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void clickloginbutton() {
		driver.findElement(loginbtn).click();
	}
	public HomePage LoginUser(String user, String pass) {
		
		enterusername(user);
		enterpassword(pass);
		clickloginbutton();
		return new HomePage(driver);
	}
	
	

}
