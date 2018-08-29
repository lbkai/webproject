package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Date d = new Date();
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
      String today = sdf.format(d);
      System.out.println(today);
	}

}
