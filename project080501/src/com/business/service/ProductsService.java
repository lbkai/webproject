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
				
				list.add(new Products(productID, product_name, income_price, new Providers(providerID, provider_name), quantity, sales_price, new Categorys(categoryID, category_name), income_time));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				//得到category对象的两个属性
				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				
				String income_time = set.getString("income_time");
				
				list.add(new Products(productID, product_name, income_price,
						new Providers(providerID, provider_name), quantity,
						sales_price, new Categorys(categoryID, category_name), 
						income_time));
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


}
