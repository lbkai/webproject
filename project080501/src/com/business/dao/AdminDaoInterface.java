package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Admin;
import com.business.util.Page;

public interface AdminDaoInterface {

	//登录
	public ResultSet selectAdminByLogin(Connection conn,Admin admin)throws SQLException;
	//新增
	public int insertAdmin(Connection conn,Admin admin)throws SQLException;
	//查询所有
	public ResultSet selectAllAdmin(Connection conn)throws SQLException;
	//查询admin分页
	public ResultSet selectAllAdminByPage(Connection conn,Page<Admin> page)throws SQLException;
	//查询得到总记录数totalRecord Page类中
	public int getAllRecord(Connection conn)throws SQLException;

}
