package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.customDataProvider;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.Helper;

public class LoginTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage home;

	@Test(dataProvider = "Login",dataProviderClass = customDataProvider.class)
	public void login(String uname,String pass) throws InterruptedException 
	{ 
		//instead of creating class object we can use page factory which can return class object
		LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
		home= loginpage.LoginUser(uname, pass);
		Helper.wait(5);
		Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"),"URL pattern did not match");
	}
	
	@Test(dependsOnMethods="login")
	public void logout()
	{ 
	  home.gotomainmenu();
      home.logout();
      Helper.wait(3);
	}	
	
	
	/*@Test(dataProvider = "IncorrectLogin",dataProviderClass = customDataProvider.class)
	public void Incorrectlogin(String uname,String pass) throws InterruptedException 
	{ 
		driver.findElement(By.id("user-name")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"),"URL pattern did not match");
	}*/
}
