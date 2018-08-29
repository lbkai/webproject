package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Products;
import com.business.util.Page;

public interface ProductsDaoInterface {
	
	//增加
	public int insertProducts(Connection conn,Products product)throws SQLException;
	//删除
	public int deleteProducts(Connection conn,Products product)throws SQLException;
	//修改
	public int updateProducts(Connection conn,Products product)throws SQLException;
	//查找
	public ResultSet selectProductsByPage(Connection conn)throws SQLException;
	//分页查找
	public ResultSet selectAllProductsByPage(Connection conn,Page<Products> page)throws SQLException;
	public int selectAllProductsRecored(Connection conn)throws SQLException;
}
