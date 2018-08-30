package com.business.view;

import java.util.List;

import com.business.entity.Categorys;
import com.business.service.CatergorysService;
import com.business.util.Page;

public class CategoryProcess {
	CatergorysService cs = new  CatergorysService();
	
		public void process(){
			System.out.println("1:增加目录   2:删除目录      3：修改目录  4：查目录     5:分页查找   6：退出");
			String op = Process.input();
			while(true){
				if("1".equals(op)){
					System.out.println("输入目录的名称：");
					String category_name = Process.input();
					System.out.println("输入目录的备注：");
					String category_desc = Process.input();
					cs.addCategorys(new Categorys(category_name, category_desc));
				}else if("2".equals(op)){
					System.out.println("输入要删除目录的id:");
					String categoryid = Process.input();
					int categoryID = Integer.parseInt(categoryid);
					cs.removeCategorysByCid(categoryID);
				}else if("3".equals(op)){
					System.out.println("输入要修改目录的id:");
					String categoryid = Process.input();
					int categoryID = Integer.parseInt(categoryid);
					cs.removeCategorysByCid(categoryID);
					System.out.println("输入修改的目录名称：");
					String category_name = Process.input();
					System.out.println("输入修改的目录备注：");
					String category_desc = Process.input();
					cs.updateCategorys(new Categorys(category_name, category_desc));
				}else if("4".equals(op)){
					List<Categorys> list =cs.findAllCategorys();
					for (Categorys categorys : list) {
						System.out.println(categorys);
					}
				}else if("5".equals(op)){
					System.out.println("输入页数！！！");
					String currentPage = Process.input();
					int currentPage1 = Integer.parseInt(currentPage);
					System.out.println("输入每页显示条数！！！");
					String pageSize = Process.input();
					int pageSize1 = Integer.parseInt(pageSize);
					
					Page<Categorys> page = cs.findtAllCategorysByPage(new Page<Categorys>(currentPage1,pageSize1));
					List<Categorys> list = page.getList();
					for (Categorys a : list) {
						System.out.println(a);
					}
					
					while (true) {					
						
						System.out.println("1:首页     2:上一页   3：下一页   4：尾页    5：退出");
						
						String op1 = Process.input();
						if("1".equals(op1)){
							 int firstPage = page.firstPage();
							 Page<Categorys> page2 = cs.findtAllCategorysByPage(new Page<Categorys>(firstPage, pageSize1));
							 List<Categorys> list2 = page2.getList();
							 for (Categorys categorys : list2) {
								System.out.println(categorys);
							}
						}else if("2".equals(op1)){
							int upPage = page.getUpPage();
							 Page<Categorys> page3 = cs.findtAllCategorysByPage(new Page<Categorys>(upPage, pageSize1));
							 List<Categorys> list3 = page3.getList();
							 for (Categorys categorys : list3) {
								System.out.println(categorys);
							}
						}else if("3".equals(op1)){
							int nextPage = page.getNextPage();
							 Page<Categorys> page4 = cs.findtAllCategorysByPage(new Page<Categorys>(nextPage, pageSize1));
							 List<Categorys> list4 = page4.getList();
							 for (Categorys categorys : list4) {
								System.out.println(categorys);
							}
						}else if("4".equals(op1)){
							int lastPage = page.lastPage();
							 Page<Categorys> page5 = cs.findtAllCategorysByPage(new Page<Categorys>(lastPage, pageSize1));
							 List<Categorys> list5 = page5.getList();
							 for (Categorys categorys : list5) {
								System.out.println(categorys);
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
