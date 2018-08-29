package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreateTable {
	public void createTable() throws Exception {
		String sql ="CREATE TABLE  student(id bigint(20) PRIMARY KEY AUTO_INCREMENT,name varchar(20),age int(11));";
		//1����������   jdk5.0֮���ü���
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql:///users", "root", "root");
		//3������������
		Statement st = conn.createStatement();
		//4��ִ��sql���
		int row = st.executeUpdate(sql);
		st.close();
		conn.close();
		System.out.println(row);//����ֵ0
	}
	
	public void createTable1() {
		String sql ="CREATE TABLE  student(id bigint(20) PRIMARY KEY AUTO_INCREMENT,name varchar(20),age int(11));";
		Connection conn = null;
		Statement st = null;
		
		try {
			//1����������
			Class.forName("com.mysql.jdbc.Driver");
			//2��ȡ����
			conn = DriverManager.getConnection("jdbc:mysql:///users", "root","root");
			//3������������
			st = conn.createStatement();
			//4��ִ��sql���
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
