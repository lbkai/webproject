package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class TestDML {
	@Test
	public void testInsert() throws Exception{
		String sql = "INSERT INTO student(name,age) VALUES('张三',30);";
		
		//1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","root");
		//3、创建语句对象
		Statement st = conn.createStatement();
		//4、执行sql语句
		int row = st.executeUpdate(sql);
		//5、释放资源
		st.close();
		conn.close();
		System.out.println(row);
	}
	@Test
	public void testDelete() throws Exception{
		String sql = "delete  from student where id = 1;";
		
		//1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","root");
		//3、创建语句对象
		Statement st = conn.createStatement();
		//4、执行sql语句
		int row = st.executeUpdate(sql);
		//5、释放资源
		st.close();
		conn.close();
		System.out.println(row);
	}
	@Test
	public void testUpdate() throws Exception{
		String sql = "update student set age = 28 where id = 1 ;";
		
		//1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","root");
		//3、创建语句对象
		Statement st = conn.createStatement();
		//4、执行sql语句
		int row = st.executeUpdate(sql);
		//5、释放资源
		st.close();
		conn.close();
		System.out.println(row);
	}
}
