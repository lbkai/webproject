package com.business.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeHelper {
	//得到时间（时间转成字符串）
	public static String getTime(String t){
		Date date = new Date();
		System.out.println(date);
		//long time = date.getTime();
		//  HH  kk   24小时制      hh   12小时制
		SimpleDateFormat f = new SimpleDateFormat();			
		return f.format(date);
	}
	
	
	public void getTime2(){
		//方法二：使用Calendar类
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get((Calendar.MONTH)+1);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String str = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
		System.out.println(str);
	}
	//把String转成Date对象
	public static Date getDateFormatString(String time,String formatStr){
		SimpleDateFormat f = new SimpleDateFormat(formatStr);
		try{
			return f.parse(time);//f.parse()方法返回值是Date
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
