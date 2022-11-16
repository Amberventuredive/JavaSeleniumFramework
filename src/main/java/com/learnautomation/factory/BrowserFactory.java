package com.learnautomation.factory;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver browsersetup(String browsername) {
		WebDriver driver =null;
		
		if(browsername.equalsIgnoreCase("Chrome") || browsername.equalsIgnoreCase("google chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox") || browsername.equalsIgnoreCase("ff")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("Edge") || browsername.equalsIgnoreCase("microsoft Edge")){
		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}	
		else if(browsername.equalsIgnoreCase("ChromeHeadless") || browsername.equalsIgnoreCase("google Chrome headless")){
			
			ChromeOptions opt = new ChromeOptions();
			opt.setHeadless(true);
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver(opt);
		}
       else if(browsername.equalsIgnoreCase("Firefox Headless") || browsername.equalsIgnoreCase("ff headless")){
			
			FirefoxOptions opt = new FirefoxOptions();
			opt.setHeadless(true);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(opt);
		}
       else if(browsername.equalsIgnoreCase("Edge headless") || browsername.equalsIgnoreCase("microsoft Edge headless")){
			
			EdgeOptions opt = new EdgeOptions();
			opt.setHeadless(true);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(opt);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		return driver;
		
	}
	public static WebDriver browsersetup(String osName, String osVersion, String browserName, String browserVersion )  {
		WebDriver driver =null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", osName);
		caps.setCapability("os_version", osVersion);
		caps.setCapability("browser", browserName);
		caps.setCapability("browser_version", browserVersion);
		
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
		driver = new RemoteWebDriver(hubURL,caps);
		return driver;
		
	}

}
