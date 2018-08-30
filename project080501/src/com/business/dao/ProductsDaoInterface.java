package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Products;
import com.business.entity.Providers;
import com.business.util.Page;

public interface ProductsDaoInterface {
	
	//增加
	public int insertProducts(Connection conn,Products products)throws SQLException;
	//删除
	public int deleteProducts(Connection conn,Products products)throws SQLException;
	//修改
	public int updateProducts(Connection conn,Products products)throws SQLException;
	//查找
	public ResultSet selectAllProducts(Connection conn)throws SQLException;
	//分页查找
	public ResultSet selectAllProductsByPage(Connection conn,Page<Products> page)throws SQLException;
	public int selectAllProductsRecored(Connection conn)throws SQLException;
	//验证是否可以删除providers数据
	public ResultSet selecProductsByPvid(Connection conn,int pvid)throws SQLException;
	//验证是否可以删除categorys数据
	public ResultSet selecProductsByCid(Connection conn,int cid)throws SQLException;
}
