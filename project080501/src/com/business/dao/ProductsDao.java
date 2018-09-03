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
		String sql = "insert into products(product_name,income_price,providerID,quantity,sales_price,categoryID,income_time)values(?,?,?,?,?,?,?)";
		Object[] objs = {products.getProduct_name(),products.getIncome_price(),products.getProviders().getProviderID(),products.getQuantity(),products.getSales_price(),products.getCategorys().getCategoryID(),products.getIncome_time()};
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
		String sql = "update products set product_name = ? ,income_price = ? , providerID = ? , quantity = ? , sales_price = ?, categoryID = ? ,income_time = ? where productID = ?";
		Object[] objs = {products.getProduct_name(),products.getIncome_price(),products.getProviders().getProviderID(),
				         products.getQuantity(),products.getSales_price(),
				         products.getCategorys().getCategoryID() ,products.getIncome_time(),products.getProductID()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public ResultSet selectAllProducts(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select p.* ,c.category_name , pro.provider_name " +
                " from products p,categorys c,providers pro " +
                " where p.categoryID = c.categoryID and p.providerID = pro.providerID ";
		
		return super.selectDate(conn, sql, null);
	}

	@Override
	public ResultSet selectAllProductsByPage(Connection conn, Page<Products> page) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select p.*,c.category_name,pro.provider_name " +
                    " from products p,categorys c,providers pro " +
                    " where p.categoryID = c.categoryID and p.providerID = pro.providerID limit ? , ?";
		Object[] objs ={(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()};
		return super.selectDate(conn, sql, objs);
	}

	@Override
	public int selectAllProductsRecored(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		int i = 0;
		String sql = "select count(*) from products";
		ResultSet set = super.selectDate(conn, sql, null);
		if(set.next()){
			i = set.getInt(1);
		}
		return i;
	}
	
	/**
	 * 验证providers数据是否可以删除
	 */


	@Override
	public ResultSet selecProductsByPvid(Connection conn, int pvid) throws SQLException {
		String sql = "select * from products where providerID= ?";
		Object[] objs = {pvid};
		return super.selectDate(conn, sql, objs);
	}
	/**
	 * 验证categorys数据是否可以删除
	 */
	@Override
	public ResultSet selecProductsByCid(Connection conn, int cid) throws SQLException {
		String sql = "select * from products where categoryID = ?";
		Object[] objs = {cid};
		return super.selectDate(conn, sql, objs);
	}

}
