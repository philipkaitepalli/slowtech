package org.jc.kp.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
	
	public static Date stringToUtilDate(String dt) {
		System.out.println("stringToUtilDate(String dt)=="+dt);
		try {
			  SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");  
			  Date date=formatter.parse(dt);
			System.out.println("String date to utildate = "+date);
			return date ;
		} catch (Exception e) {
			System.out.println("eeeeeeeeee"+e);
		}
      return null;
	}
	public static String utilDateToString(Date date) {
		
		String strDate;  
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			strDate = dateFormat.format(date);
			System.out.println("string date=" + strDate);
			return strDate;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static Date utilDateToSqlDate(Date date) {
		return null;
	}
	public static Date sqlDateToUtilDate(Date date) {
		return null;
	}
	
}
