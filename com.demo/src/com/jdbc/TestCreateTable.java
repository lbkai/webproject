package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreateTable {
	public void createTable() throws Exception {
		String sql ="CREATE TABLE  student(id bigint(20) PRIMARY KEY AUTO_INCREMENT,name varchar(20),age int(11));";
		//1、加载驱动   jdk5.0之后不用加载
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql:///users", "root", "root");
		//3、创建语句对象
		Statement st = conn.createStatement();
		//4、执行sql语句
		int row = st.executeUpdate(sql);
		st.close();
		conn.close();
		System.out.println(row);//返回值0
	}
	
	public void createTable1() {
		String sql ="CREATE TABLE  student(id bigint(20) PRIMARY KEY AUTO_INCREMENT,name varchar(20),age int(11));";
		Connection conn = null;
		Statement st = null;
		
		try {
			//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2获取连接
			conn = DriverManager.getConnection("jdbc:mysql:///users", "root","root");
			//3、创建语句对象
			st = conn.createStatement();
			//4、执行sql语句
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(st != null) {
					st.close();	
				}	
			}catch(Exception e){
				
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}finally {
					
				}
			}
				
		}
		
	}
	
}
