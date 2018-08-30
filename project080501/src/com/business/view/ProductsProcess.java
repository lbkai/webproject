package com.business.view;

import java.util.List;

import org.junit.Test;


import com.business.entity.Categorys;
import com.business.entity.Products;
import com.business.entity.Providers;
import com.business.service.ProductsService;
import com.business.util.Page;

public class ProductsProcess {
	
	 ProductsService ps = new ProductsService();
	@Test
	public  void process(){
		while(true){
			System.out.println("1:增加产品   2:删除产品      3：修改产品   4：查产品     5:分页查找   6：退出");
			String op = Process.input();
			if("1".equals(op)){
				System.out.println("输入产品名：");
				String product_name = Process.input();
				System.out.println("输入产品进价：");
				String productprice = Process.input();
				double income_price = Double.parseDouble(productprice);
				System.out.println("输入供应商id：");
				String providerid = Process.input();
				int providerID = Integer.parseInt(providerid);
				System.out.println("输入产品数量：");
				String quanti = Process.input();
				int quantity = Integer.parseInt(quanti);
				System.out.println("输入产品售价：");
				String salesprice = Process.input();
				double sales_price = Double.parseDouble(salesprice);
				System.out.println("输入产品种类id：");
				String categoryid = Process.input();
				int categoryID = Integer.parseInt(categoryid);
				System.out.println("输入采购时间：");
				String income_time = Process.input();			
				ps.addProducts(new Products(product_name, income_price, new Providers(providerID), quantity, sales_price, new Categorys(categoryID), income_time));
				
			}else if("2".equals(op)){
				System.out.println("输入要删除产品的id:");
				String productid = Process.input();
				int productID = Integer.parseInt(productid);
				ps.removeProducts(new Products(productID));
			}else if("3".equals(op)){
				System.out.println("输入要修改产品的id:");
				String productid = Process.input();
				int productID = Integer.parseInt(productid);
				System.out.println("输入修改的产品名：");
				String product_name = Process.input();
				System.out.println("输入修改的产品进价：");
				String productprice = Process.input();
				double income_price = Double.parseDouble(productprice);
				System.out.println("输入修改的供应商id：");
				String providerid = Process.input();
				int providerID = Integer.parseInt(providerid);
				System.out.println("输入修改的产品数量：");
				String quanti = Process.input();
				int quantity = Integer.parseInt(quanti);
				System.out.println("输入修改的产品售价：");
				String salesprice = Process.input();
				double sales_price = Double.parseDouble(salesprice);
				System.out.println("输入修改的产品种类id：");
				String categoryid = Process.input();
				int categoryID = Integer.parseInt(categoryid);
				System.out.println("输入修改的采购时间：");
				String income_time = Process.input();
				
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
			
		}
	}
}
