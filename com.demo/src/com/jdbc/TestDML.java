package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class TestDML {
	@Test
	public void testInsert() throws Exception{
		String sql = "INSERT INTO student(name,age) VALUES('����',30);";
		
		//1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2���������Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","root");
		//3������������
		Statement st = conn.createStatement();
		//4��ִ��sql���
		int row = st.executeUpdate(sql);
		//5���ͷ���Դ
		st.close();
		conn.close();
		System.out.println(row);
	}
	@Test
	public void testDelete() throws Exception{
		String sql = "delete  from student where id = 1;";
		
		//1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2���������Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","root");
		//3������������
		Statement st = conn.createStatement();
		//4��ִ��sql���
		int row = st.executeUpdate(sql);
		//5���ͷ���Դ
		st.close();
		conn.close();
		System.out.println(row);
	}
	@Test
	public void testUpdate() throws Exception{
		String sql = "update student set age = 28 where id = 1 ;";
		
		//1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2���������Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","root");
		//3������������
		Statement st = conn.createStatement();
		//4��ִ��sql���
		int row = st.executeUpdate(sql);
		//5���ͷ���Դ
		st.close();
		conn.close();
		System.out.println(row);
	}
}
