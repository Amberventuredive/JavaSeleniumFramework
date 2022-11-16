package com.learnautomation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.learnautomation.factory.BrowserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseClass {
	
	public WebDriver driver;
	
	@Parameters({"cloud","os","os_version","browser","	browser_version"})
	@BeforeClass
	public void setup(@Optional("false")String cloud, @Optional("")String os, @Optional("")String os_version, @Optional("")String browser, @Optional("")String browser_version)
	{
		if(cloud.equalsIgnoreCase("true")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", os);
			caps.setCapability("os_version", os_version);
			caps.setCapability("browser", browser);
			caps.setCapability("browser_version", browser_version);
			
			final String USERNAME="amber_2QToXF";
			final String AUTOMATE_KEY="pg5q5VNJfwxWu65sxthd";
			final String finalURL= "Https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

			URL hubURL = null;
			try {
				
				hubURL = new URL(finalURL);
			} catch (MalformedURLException e) {
				
				System.out.print("URL fromat is incorrect"+e);
				e.printStackTrace();
			}
			driver= new RemoteWebDriver(hubURL,caps);
		}
		else {
			driver=	BrowserFactory.browsersetup("chrome");
			
		}
		driver.get("https://www.saucedemo.com/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
