package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
	
    static Properties pro;
    
	public static String getValue(String key) {
		createInstance();
		return pro.getProperty(key).toString();
		
	}
	public static void createInstance() {
		System.out.println("LOG-Info: Creating new session for properties file");
			
			pro=new Properties();
			
			try {
				
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties")));
		
			}
			catch(FileNotFoundException e) {
				System.out.println("Exception "+e.getMessage());
			}
			catch(IOException e) {
				System.out.println("Exception "+e.getMessage());
			}
			
	
	}
}
