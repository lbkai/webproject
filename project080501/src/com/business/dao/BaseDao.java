package com.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//这个类提供最基本的通用的增删改查的方法
public class BaseDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet set;

	// 通用的增删改executeUpdate()
	public int updateDate(Connection conn, String sql, Object[] objs) throws SQLException {
		this.conn = conn;
		ps = conn.prepareStatement(sql);
		// 解析问号
		if(objs != null){
		System.out.println(objs.length);
		for (int i = 0; i < objs.length; i++) {
			ps.setObject(i + 1, objs[i]);
		}
		}

		return ps.executeUpdate();
	}

	// 通用的查询executeQuery()
	public ResultSet selectDate(Connection conn, String sql, Object[] objs) throws SQLException {
		this.conn = conn;
		ps = conn.prepareStatement(sql);
		// 解析问号
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i + 1, objs[i]);
			}
		}
		return ps.executeQuery();
	}
	//关闭资源
			public void closeALL(){
				try{
					if(set != null){
						set.close();
					}
					if(ps != null){
						ps.close();
					}
					if(conn != null){
						conn.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					conn = null;
					ps = null;
					set = null;
					System.out.println("资源关闭了---");
				}
			}
}
