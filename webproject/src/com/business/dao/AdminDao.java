package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Admin;
import com.business.util.Page;

public class AdminDao extends BaseDao implements AdminDaoInterface{

	@Override
	public ResultSet selectAdminByLogin(Connection conn, Admin admin) throws SQLException {		
		String sql = "select * from admin where admin_name = ? and admin_password = ?";
		Object[] objs = {admin.getAdmin_name(),admin.getAdmin_password()};
		return super.selectDate(conn,sql,objs);
	}

	@Override
	public int insertAdmin(Connection conn, Admin admin) throws SQLException {

		String sql = "insert into admin(admin_id,admin_name,admin_password)values(?,?,?)";
		Object[] objs = {admin.getAdmin_id(),admin.getAdmin_name(),admin.getAdmin_password()};	
		return super.updateDate(conn, sql, objs);
	}
	
	@Override
	public int deleteAdmin(Connection conn, Admin admin) throws SQLException {
		String sql = "delete from admin where admin_id = ? ";
		Object[] objs = {admin.getAdmin_id()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int updateAdmin(Connection conn, Admin admin) throws SQLException {
		String sql = "update  admin set admin_name = ? ,admin_password = ?,admin_date = ? where admin_id = ?";
		Object[] objs = {admin.getAdmin_name(),admin.getAdmin_password(),admin.getDate(),admin.getAdmin_id()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public ResultSet selectAllAdmin(Connection conn) throws SQLException {
	
		String sql = "select * from admin";
		return super.selectDate(conn, sql,null);
	}

	@Override
	public ResultSet selectAllAdminByPage(Connection conn, Page<Admin> page) throws SQLException {
		
		String sql = "select * from admin limit ? , ?";
		
		Object[] objs = {(page.getCurrentPage()-1) * page.getPageSize(),page.getPageSize()};
		return super.selectDate(conn, sql, objs);
	}

	@Override
	public int getAllRecord(Connection conn) throws SQLException {
		
		int i = 0;
		String sql = "select count(*) from admin";
		ResultSet set = super.selectDate(conn, sql, null);
		if(set.next()){
			i = set.getInt(1);//1是显示第一列
		}
		return i;
	}


	
	
	

}
