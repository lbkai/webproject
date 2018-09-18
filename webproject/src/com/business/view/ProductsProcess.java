package com.business.view;

import java.util.List;

import org.junit.Test;


import com.business.entity.Categorys;
import com.business.entity.Products;
import com.business.entity.Providers;
import com.business.excepption.NotNullException;
import com.business.excepption.ValueExistException;
import com.business.service.ProductsService;
import com.business.util.Page;

public class ProductsProcess {
	
	 ProductsService ps = new ProductsService();
	 
	 public  void checkProductID(int productID) throws ValueExistException{
		 /**
		  * 判断productID是否存在
		  */
//		 List<Products> list = ps.findAllProducts();
//		 Iterator<Products> it = list.iterator();
//		 for (Products products : list) {
//			if(products.getProductID() != productID){
//				
//			}
//		}
		 
			for(int i = 0;i<ps.findAllProducts().size();i++){
				if(!(ps.findAllProducts().get(i).getProductID() == productID) && i == ps.findAllProducts().size() - 1){
					throw new ValueExistException();
				}
			}
	 }
	 public void checkProviderID(int providerID) throws ValueExistException{
		 /**
		  * 判断providerID是否存在
		  */
		 for(int i = 0 ;i<ps.findAllProducts().size();i++){
				
				if(!((ps.findAllProducts().get(i).getProviders().getProviderID()) == providerID) && i == ps.findAllProducts().size()-1){
					throw new ValueExistException();
				}
			}
	 }
	 public void checkcategoryID(int categoryID) throws ValueExistException{
		 /**
		  * 判断categoryID是否存在
		  */
		   for(int i = 0 ;i<ps.findAllProducts().size();i++){
				if(!((ps.findAllProducts().get(i).getCategorys().getCategoryID()) == categoryID)&&i == ps.findAllProducts().size()-1){
					throw new ValueExistException();
				}
			}
	 }
	 
	 
	@Test
	public  void process() throws NotNullException, ValueExistException{
		while(true){
			System.out.println("1:增加产品   2:删除产品      3：修改产品   4：查产品     5:分页查找   6：退出");
			String op = Process.input();
			try{
			if("1".equals(op)){
				
				System.out.println("输入产品名：");
				String product_name = Process.input();
				if(product_name.length() == 0){
					throw new NotNullException();			
			      }
				System.out.println("输入产品进价：");
				String productprice = Process.input();
				double income_price = Double.parseDouble(productprice);
				System.out.println("输入供应商id：");
				String providerid = Process.input();
				int providerID = Integer.parseInt(providerid);				
				checkProviderID(providerID);				
				System.out.println("输入产品数量：");
				String quanti = Process.input();
				int quantity = Integer.parseInt(quanti);
				System.out.println("输入产品售价：");
				String salesprice = Process.input();
				double sales_price = Double.parseDouble(salesprice);
				System.out.println("输入产品种类id：");
				String categoryid = Process.input();
				int categoryID = Integer.parseInt(categoryid);				
	           checkcategoryID(categoryID);	 	           
				System.out.println("输入采购时间：");
				String income_time = Process.input();
				if(income_time.trim().length() == 0){
					throw new NotNullException();			
			      }
			
				ps.addProducts(new Products(product_name, income_price, new Providers(providerID), quantity, sales_price, new Categorys(categoryID), income_time));			
								
				
			}else if("2".equals(op)){
				System.out.println("输入要删除产品的id:");
				String productid = Process.input();
				int productID = Integer.parseInt(productid);
				
			    checkProductID(productID);
				
				ps.removeProducts(new Products(productID));
			  }else if("3".equals(op)){
				System.out.println("输入要修改产品的id:");
				String productid = Process.input();
				int productID = Integer.parseInt(productid);
				
				checkProductID(productID);
				
				System.out.println("输入修改的产品名：");
				String product_name = Process.input();
				if(product_name.length() == 0){
					throw new NotNullException();			
			      }
				
				
				System.out.println("输入修改的产品进价：");
				String productprice = Process.input();
				double income_price = Double.parseDouble(productprice);
				System.out.println("输入修改的供应商id：");
				String providerid = Process.input();
				int providerID = Integer.parseInt(providerid);
				
				checkProviderID(providerID);
				
				System.out.println("输入修改的产品数量：");
				String quanti = Process.input();
				int quantity = Integer.parseInt(quanti);
				System.out.println("输入修改的产品售价：");
				String salesprice = Process.input();
				double sales_price = Double.parseDouble(salesprice);
				System.out.println("输入修改的产品种类id：");
				String categoryid = Process.input();
				int categoryID = Integer.parseInt(categoryid);
				
				checkcategoryID(categoryID);
				
				System.out.println("输入修改的采购时间：");
				String income_time = Process.input();
				if(income_time.trim().length() == 0){
					throw new NotNullException();			
			      }
				
				ps.updateProducts(new Products(productID,product_name, income_price, new Providers(providerID), quantity, sales_price, new Categorys(categoryID), income_time));
			}else if("4".equals(op)){
				List<Products> list = ps.findAllProducts();
				for (Products products : list) {
					System.out.println(products);
				}
			}else if("5".equals(op)){
				System.out.println("输入页数！！！");
				String currentPage = Process.input();
				int currentPage1 = Integer.parseInt(currentPage);
				System.out.println("输入每页显示条数！！！");
				String pageSize = Process.input();
				int pageSize1 = Integer.parseInt(pageSize);
				
				Page<Products> page = ps.findAllProductByPage(new Page<Products>(currentPage1,pageSize1));
				List<Products> list = page.getList();
				for (Products a : list) {
					System.out.println(a);
				}
				
				while (true) {					
					
					System.out.println("1:首页     2:上一页   3：下一页   4：尾页    5：退出");
					
					String op1 = Process.input();
					if("1".equals(op1)){
						 int firstPage = page.firstPage();
						 Page<Products> page2 = ps.findAllProductByPage(new Page<Products>(firstPage, pageSize1));
						 List<Products> list2 = page2.getList();
						 for (Products admin : list2) {
							System.out.println(admin);
						}
					}else if("2".equals(op1)){
						int upPage = page.getUpPage();
						 Page<Products> page3 = ps.findAllProductByPage(new Page<Products>(upPage, pageSize1));
						 List<Products> list3 = page3.getList();
						 for (Products admin : list3) {
							System.out.println(admin);
						}
					}else if("3".equals(op1)){
						int nextPage = page.getNextPage();
						 Page<Products> page4 = ps.findAllProductByPage(new Page<Products>(nextPage, pageSize1));
						 List<Products> list4 = page4.getList();
						 for (Products admin : list4) {
							System.out.println(admin);
						}
					}else if("4".equals(op1)){
						int lastPage = page.lastPage();
						 Page<Products> page5 = ps.findAllProductByPage(new Page<Products>(lastPage, pageSize1));
						 List<Products> list5 = page5.getList();
						 for (Products admin : list5) {
							System.out.println(admin);
						}
					}else if("5".equals(op1)){
						break;
					}
				}
			}else if("6".equals(op)){
				break;
			}
			
		}catch(NumberFormatException e){
			//e.printStackTrace();
			System.out.println("数字格式异常！！");
		}
	}
   }
}
