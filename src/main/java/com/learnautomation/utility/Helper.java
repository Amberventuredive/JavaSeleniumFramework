package com.learnautomation.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

	
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
			
		}
	}
	
	public static String getdateformat() {
		Date d =new Date();
		SimpleDateFormat dateformat= new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
		return dateformat.format(d);
	}
}
