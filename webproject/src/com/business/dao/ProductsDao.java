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
		String sql = "insert into products(product_name,income_price,providerID,quantity,sales_price,categoryID,income_time)values(?,?,?,?,?,?,to_date(?,'YYYY-MM-DD HH24:MI:SS'))";
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
	public int deleteProductsById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from products where productID = ? ";
		Object[] objs = {id};
		return super.updateDate(conn, sql, objs);
	}
	
	@Override
	public int updateProducts(Connection conn, Products products) throws SQLException {
		String sql = "update products set product_name = ? ,income_price = ? , providerID = ? , quantity = ? , sales_price = ?, categoryID = ? ,income_time = to_date(?,'YYYY-MM-DD HH24:MI:SS') where productID = ?";
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
	public ResultSet selectProductsByName(Connection conn,String name) throws SQLException{
		String sql = "select * from products where product_name = ?";
		Object[] objs = {name};
		return super.selectDate(conn, sql, objs);
	   
   }
	@Override
	public ResultSet selectAllProductsByPage(Connection conn, Page<Products> page) throws SQLException {
		// mysql
	/*	String sql ="select p.*,c.category_name,pro.provider_name " +
                    " from products p,categorys c,providers pro " +
                    " where p.categoryID = c.categoryID and p.providerID = pro.providerID limit ? , ?";*/
		//oracle
	/*	String sql ="select rn,t.* from (select rownum rn, p.*,c.category_name,pro.provider_name " +
                " from products p,categorys c,providers pro " +
                " where p.categoryID = c.categoryID and p.providerID = pro.providerID and rownum<=?) t where t.rn>? ";*/
		
		String sql = "select rn,t.* from (select rownum rn, p.*,c.category_name,pro.provider_name from (select * from products order by productID) p ,categorys c,providers pro " + 
				"where p.categoryID = c.categoryID and p.providerID = pro.providerID and rownum<=?) t where t.rn>?";
		
		//mysql
		//Object[] objs ={(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()};
		//oracle
		Object[] objs ={page.getCurrentPage()*page.getPageSize(),(page.getCurrentPage()-1)*page.getPageSize()};
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
     //通过id查找
	@Override
	public ResultSet selectAllProductById(Connection conn, int id) throws SQLException {						
			String sql = "select p.productID,p.product_name,p.income_price,p.providerID,p.quantity,p.sales_price,p.categoryID,to_char(p.income_time,'yyyy-mm-dd hh24:mi:ss') income_time ,c.category_name , pro.provider_name " +
	                " from products p,categorys c,providers pro " +
	                " where p.categoryID = c.categoryID and p.providerID = pro.providerID and p.productID = ? ";
			Object[] objs = {id};
			return super.selectDate(conn, sql, objs);
		
	}

}
