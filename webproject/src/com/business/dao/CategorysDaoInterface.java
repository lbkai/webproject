package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Categorys;
import com.business.util.Page;

public interface CategorysDaoInterface {

	// 增加
	public int insertCategorys(Connection conn, Categorys categorys) throws SQLException;

	// 删除
	public int deleteCategorysByCid(Connection conn, int cid) throws SQLException;

	// 修改
	public int updateCategorys(Connection conn, Categorys categorys) throws SQLException;

	// 查找
	public ResultSet selectAllCategorys(Connection conn) throws SQLException;
	// 查找
	public ResultSet selectCategoryById(Connection conn,int id) throws SQLException;
	// 分页查找
	public ResultSet selectAllCategorysByPage(Connection conn, Page<Categorys> page) throws SQLException;

	// 查询得到总记录数totalRecord Page类中
	public int getAllRecord(Connection conn) throws SQLException;
}
