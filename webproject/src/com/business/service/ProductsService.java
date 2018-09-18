package com.business.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.business.dao.ProductsDao;
import com.business.entity.Categorys;
import com.business.entity.Products;
import com.business.entity.Providers;
import com.business.util.DBHelper;
import com.business.util.Page;

public class ProductsService implements ProductsServiceInterface{
	
	private  ProductsDao pd;
	public ProductsService(){
		pd = new ProductsDao();
	}
	
	@Override
	public boolean addProducts(Products products) {
		boolean f = false;
		Connection conn = DBHelper.getConnection();
		try {
			int i = pd.insertProducts(conn, products);
			if(i>0){
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}		
		return f;		
	}
	
	//产品同名校验
	public int addProductsByName(Products products) {		
		Connection conn = DBHelper.getConnection();
		try {
			ResultSet set = pd.selectProductsByName(conn, products.getProduct_name());
			if(!set.next()) {				
				return  pd.insertProducts(conn, products);
			}else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}		
		return 0;		
	}
	
	@Override
	public boolean removeProducts(Products products) {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		boolean f = false;
		try {
			int i = pd.deleteProducts(conn, products);
			if(i>1){
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		return f;
	}
	
	//通过id删除
	public boolean removeProductsById(int id) {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		boolean f = false;
		try {
			int i = pd.deleteProductsById(conn, id);
			if(i>0){
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		return f;
	}
	
	
	public int modifyProduct(Products p) {
		Connection conn = DBHelper.getConnection();
		try {
			return pd.updateProducts(conn, p);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			pd.closeALL();
		}
		return 0;
	}

	@Override
	public boolean updateProducts(Products products) {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		boolean f = false;
		try {
			int i = pd.updateProducts(conn, products);
			if(i>1){
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		return f;
	}

	
	@Override
	public List<Products> findAllProducts() {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		List<Products> list  = new ArrayList<Products>();
		try {
			ResultSet set = pd.selectAllProducts(conn);
			while(set.next()){
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				
				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				
				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String income_time = set.getString("income_time");
				
				list.add(new Products(productID,product_name, income_price, new Providers(providerID, provider_name), quantity, sales_price, new Categorys(categoryID, category_name), income_time));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		
		return list;
	}
	
	@Override
	public Page<Products> findAllProductByPage(Page<Products> page) {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		List<Products> list = new ArrayList<Products>();
		try {
			ResultSet set = pd.selectAllProductsByPage(conn, page);
			while(set.next()){
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				//得到provider对象的两个属性
				//int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				//得到category对象的两个属性
				//int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				
				String income_time = set.getString("income_time");
				
				list.add(new Products(productID,product_name, income_price, new Providers( provider_name), quantity, sales_price, new Categorys( category_name), income_time));
			}	
			//三个参数有值
			page.setList(list);
			int allRecord = pd.selectAllProductsRecored(conn);
			page.setTotalRecord(allRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		return page;
	}

	/**
	 * 验证providers数据是否可以删除
	 */
	@Override
	public List<Products> findAllProductsByPvid(int providerID) {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		List<Products> list  = new ArrayList<Products>();
		try {
			ResultSet set = pd.selecProductsByPvid(conn, providerID);
			while(set.next()){
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				
				//int providerID = set.getInt("providerID");
				//String provider_name = set.getString("provider_name");
				
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				
				int categoryID = set.getInt("categoryID");
				//String category_name = set.getString("category_name");
				String income_time = set.getString("income_time");
				
				list.add(new Products(productID,product_name, income_price, new Providers(providerID), quantity, sales_price, new Categorys(categoryID), income_time));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		
		return list;
	}
	

	/**
	 * 验证categorys数据是否可以删除
	 */
	@Override
	public List<Products> findAllProductsBypvidCid(int categoryID) {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		List<Products> list  = new ArrayList<Products>();
		try {
			ResultSet set = pd.selecProductsByCid(conn, categoryID);
			while(set.next()){
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				
				int providerID = set.getInt("providerID");
				//String provider_name = set.getString("provider_name");
				
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				
				//int categoryID = set.getInt("categoryID");
				//String category_name = set.getString("category_name");
				String income_time = set.getString("income_time");
				
				list.add(new Products(productID,product_name, income_price, new Providers(providerID), quantity, sales_price, new Categorys(categoryID), income_time));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		
		return list;
	}
	
	@Override
	public Products findProductById(int id) {
		Connection conn = DBHelper.getConnection();
		try {
			ResultSet set = pd.selectAllProductById(conn, id);
			if(set.next()){
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				
				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				
				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String income_time = set.getString("income_time");
				
				return new Products(productID,product_name, income_price, new Providers(providerID, provider_name), quantity, sales_price, new Categorys(categoryID, category_name), income_time);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		
		return null;
	}
}


