package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Categorys;
import com.business.util.Page;

public class CatergorysDao extends BaseDao implements CategorysDaoInterface {

	@Override
	public int insertCategorys(Connection conn, Categorys categorys) throws SQLException {
		String sql = "insert into Categorys(categoryID,category_name,category_desc)values(?,?,?)";
		Object[] objs = {categorys.getCategoryID(),categorys.getCategory_name(),categorys.getCategory_desc()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int deleteCategorys(Connection conn, Categorys categorys) throws SQLException {
		String sql = "delete from categorys where categoryID = ? ";
		Object[] objs = {categorys.getCategoryID()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int updateCategorys(Connection conn, Categorys categorys) throws SQLException {
		String sql = "update categorys set category_name = ?,category_desc = ? where categoryID = ? ";
		Object[] objs = {categorys.getCategory_name(),categorys.getCategory_desc(),categorys.getCategoryID()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public ResultSet selectAllCategorys(Connection conn) throws SQLException {
		String sql = "select * from categorys";
		return super.selectDate(conn, sql, null);
	}

	@Override
	public ResultSet selectAllCategorysByPage(Connection conn, Page<Categorys> page) throws SQLException {
		String sql = "select * from categorys limit ?,?";
		Object[] objs = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
		return super.selectDate(conn, sql, objs);
	}

	@Override
	public int getAllRecord(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		int i = 0;
		String sql = "select count(*) from categorys";
		ResultSet set = super.selectDate(conn, sql, null);
		if(set.next()){
			i = set.getInt(1);//1是显示第一列
		}
		return i;
	}

}
