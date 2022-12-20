package com.learnautomation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.mail.MessagingException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.learnautomation.factory.BrowserFactory;
import com.learnautomation.utility.ConfigUtility;
import com.learnautomation.utility.ExtentManager;

/*import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;*/

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
			
			//final String USERNAME="amber_2QToXF";
			//final String AUTOMATE_KEY="pg5q5VNJfwxWu65sxthd";
			final String USERNAME="amberauto_FVlHW1";
			final String AUTOMATE_KEY="Sc3QsJD5syiib3XrCWHM";
			final String finalURL= "Https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

			URL hubURL = null;
			try {
				
				hubURL = new URL(finalURL);
			} catch (MalformedURLException e) {
				
				System.out.print("URL fromat is incorrect"+e);
				e.printStackTrace();
			}
			driver= new RemoteWebDriver(hubURL,caps);
			System.out.println("browser stack is fine");
		}
		else {
			driver=	BrowserFactory.browsersetup(ConfigUtility.getValue("browser"));
			
		}
		//String ul = ConfigUtility.getValue("url");
		System.out.println("Open URL");
		//System.out.println(ul);
		driver.get("https://www.saucedemo.com");	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	//@AfterSuite
	/*public void sendmail() {
		 Properties props = new Properties();

	        // this will set host of server- you can change based on your requirement
	        props.put("mail.smtp.host", "smtp.gmail.com");

	        // set the port of socket factory
	        props.put("mail.smtp.socketFactory.port", "465");

	        // set socket factory
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

	        // set the authentication to true
	        props.put("mail.smtp.auth", "true");

	        // set the port of SMTP server
	        props.put("mail.smtp.port", "465");

	        // This will handle the complete authentication
	        Session session = Session.getDefaultInstance(props,

	                new javax.mail.Authenticator() {

	                    protected PasswordAuthentication getPasswordAuthentication() {

	                        return new PasswordAuthentication("amberperveenautomation@gmail.com", "qcqqmgoqlwhdogxv");

	                    }

	                });

	        try {

	            // Create object of MimeMessage class
	            Message message = new MimeMessage(session);

	            // Set the from address
	            message.setFrom(new InternetAddress("amberperveenlearning@gmail.com"));

	            // Set the recipient address
	            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("amber.perveen@venturedive.com"));

	            // Add the subject link
	            message.setSubject("Testing Subject");

	            // Create object to add multimedia type content
	            BodyPart messageBodyPart1 = new MimeBodyPart();

	            // Set the body of email
	            messageBodyPart1.setText("This is message body");

	            // Create another object to add another content
	            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

	            // Mention the file which you want to send
	            //ZipUtil.pack(new File(reportFilepath), new File(reportFilepath+"/hello.zip"));
	            //String filename = reportFilepath+"/hello.zip";
	           // String filename = System.getProperty("user.dir")+"/Reports/AutomationReports"+ExtentManager.reportname+".html";
	            String filename = "/home/amber/eclipse-workspace/mavenproject/Reports/AutomationReports11_11_2022_17_19_44.html";
	            // Create data source and pass the filename
	            DataSource source = new FileDataSource(filename);

	            // set the handler
	            messageBodyPart2.setDataHandler(new DataHandler(source));

	            // set the file
	            messageBodyPart2.setFileName(filename);

	            // Create object of MimeMultipart class
	            Multipart multipart = new MimeMultipart();

	            // add body part 1
	            multipart.addBodyPart(messageBodyPart2);

	            // add body part 2
	            multipart.addBodyPart(messageBodyPart1);

	            // set the content
	            message.setContent(multipart);

	            // finally send the email
	            Transport.send(message);

	            System.out.println("=====Email Sent=====");

	        } 
	        
	        catch (MessagingException e) {
	        	System.out.println(e);

	            throw new RuntimeException(e);

	        }
		
	}*/
	
	

}
