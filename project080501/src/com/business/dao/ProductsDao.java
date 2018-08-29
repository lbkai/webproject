package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Products;
import com.business.util.Page;

public class ProductsDao extends BaseDao implements ProductsDaoInterface{

	@Override
	public int insertProducts(Connection conn, Products products) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into products(productID,product_name,income_price,prividerID,quantity,sales_price,categoryID,income_time)values(?,?,?,?,?,?,?,?)";
		Object[] objs = {products.getProductID(),products.getProduct_name(),products.getIncome_price(),products.getProductID(),products.getQuantity(),products.getSales_price(),products.getCategoryID(),products.getIncome_time()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int deleteProducts(Connection conn, Products products) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from products where productID = ? ";
		Object[] objs = {products.getProductID()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int updateProducts(Connection conn, Products products) throws SQLException {
		String sql = "update products set product_name = ? ,income_price = ? , providerID = ? , quantity = ?,sales_price = ? categoryID = ? ,income_time = ?";
		Object[] objs = {products.getProduct_name(),products.getIncome_price(),products.getProductID(),products.getQuantity(),products.getSales_price(),products.getCategoryID() ,products.getIncome_time()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public ResultSet selectAllProducts(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select p.*,c.category_name,pro.provider_name "+
                " from products p,categorys c,providers pro "+
                " where p.categoryID = c.categoryID and p.productID = pro.providerID ";
		
		return super.selectDate(conn, sql, null);
	}

	@Override
	public ResultSet selectAllProductsByPage(Connection conn, Page<Products> page) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select p.*,c.category_name,pro.provider_name "+
                    " from products p,categorys c,providers pro "+
                    " where p.categoryID = c.categoryID and p.productID = pro.providerID limit ?,?";
		Object[] objs ={(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()};
		return super.selectDate(conn, sql, objs);
	}

	@Override
	public int selectAllProductsRecored(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) from products";
		ResultSet set = super.selectDate(conn, sql, null);
		if(set.next()){
			return set.getInt(1);
		}
		return 0;
	}

}
