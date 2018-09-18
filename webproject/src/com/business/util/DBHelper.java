package com.business.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBHelper {
	//连接的关键要素做成属性
	private static String url ;
	private static String user ;
	private static String password ;
	
	//把驱动加到builpath里
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		String driver = bundle.getString("driver");
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
		driver = bundle.getString("driver");
		//1、加载驱动到程序里
		try{
			Class.forName(driver);
			System.out.println("驱动加载了---");
		}catch(ClassNotFoundException e){
			System.out.println("驱动加载失败了--");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try{
			//得到数据库的连接（DriverManage ; Connection）
			return DriverManager.getConnection(url,user,password);
		}catch(SQLException e){
			System.out.println("获取数据库连接失败");
			e.printStackTrace();
		}
		return null;
	}
	
	
}
