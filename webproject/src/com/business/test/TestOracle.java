package com.business.test;

import java.sql.Connection;

import com.business.util.DBHelper;

public class TestOracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection conn = DBHelper.getConnection();
		 System.out.println(conn);
		
	}

}
