package com.learnautomation.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    
    private static ExtentReports extent;
    public static String reportname= Helper.getdateformat();
    
    public static ExtentReports getInstance() 
    {
    	if (extent == null)
    		createInstance();
    	
        return extent;
    }
    
    public static ExtentReports createInstance() 
    
    {
    	
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/AutomationReports"+reportname+".html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Sprint Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        return extent;
    }
}