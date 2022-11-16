package com.learnautomation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	By menubutton = By.xpath("//button[text()='Open Menu']");
	By logout=By.id("logout_sidebar_link");


	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void gotomainmenu() {
		//driver.findElement(menubutton).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var menu= document.getElementById('react-burger-menu-btn');menu.click();");
		
	}
	public LoginPage logout()
	{
		//driver.findElement(menubutton).click();
		driver.findElement(logout).click();
		return new LoginPage(driver);
	}
}
