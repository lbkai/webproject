package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Categorys;
import com.business.util.Page;

public class CatergorysDao extends BaseDao implements CategorysDaoInterface {

	@Override
	public int insertCategorys(Connection conn, Categorys categorys) throws SQLException {
		String sql = "insert into Categorys(category_name,category_desc)values(?,?)";
		Object[] objs = {categorys.getCategory_name(),categorys.getCategory_desc()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int deleteCategorysByCid(Connection conn, int cid) throws SQLException {
		String sql = "delete from categorys where categoryID = ? ";
		Object[] objs = {cid};
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
		String sql = "select * from categorys ";
		return super.selectDate(conn, sql, null);
	}
	//通过id查找
	@Override
	public ResultSet selectCategoryById(Connection conn,int id) throws SQLException {
		String sql = "select * from categorys where categoryID = ?";
		Object[] objs = {id};
		return super.selectDate(conn, sql, objs);
	}
	//通过名称查找，主要应用于同名校验
	public ResultSet selectCategoryByName(Connection conn,String name) throws SQLException {
		String sql = "select * from categorys where category_name = ?";
		Object[] objs = {name};
		return super.selectDate(conn, sql, objs);
	}
	
	@Override
	public ResultSet selectAllCategorysByPage(Connection conn, Page<Categorys> page) throws SQLException {
		String sql = "select t.*,rn from (select rownum rn,c.* from  (select * from categorys order by categoryID) c where rownum <=? ) t where t.rn>?";
		//Object[] objs = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
		Object[] objs = { (page.getCurrentPage()) * page.getPageSize(), (page.getCurrentPage()-1)*page.getPageSize() };
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
