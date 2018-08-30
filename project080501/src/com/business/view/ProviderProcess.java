package com.business.view;

import java.util.List;

import org.junit.Test;

import com.business.entity.Products;
import com.business.entity.Providers;
import com.business.service.ProviderService;
import com.business.util.Page;

public class ProviderProcess {
	ProviderService ps = new ProviderService();
	
	@Test
	public void process(){
		while(true){
			System.out.println("1:增加供应商   2:删除供应商      3：修改供应商  4：查供应商     5:分页查找   6：退出");
			String op = Process.input();
			if("1".equals(op)){
				System.out.println("输入供应商的名称：");
				String provider_name = Process.input();
				System.out.println("输入供应商的地址：");
				String provider_add = Process.input();
				System.out.println("输入供应商的电话：");
				String provider_tel = Process.input();
				System.out.println("输入供应商的account:");
				String account = Process.input();
				System.out.println("输入供应商的email:");
				String email = Process.input();
				ps.addProviders(new Providers(provider_name, provider_add, provider_tel, account, email));
				
				
			}else if("2".equals(op)){
				System.out.println("输入要删除供应商的id:");
				String providerid = Process.input();
				int pvid = Integer.parseInt(providerid);
				ps.removeProvidersByPvid(pvid);
				
			}else if("3".equals(op)){
				System.out.println("输入要修改供应商的id:");
				String providerid = Process.input();
				int providerID = Integer.parseInt(providerid);								
				System.out.println("输入修改的供应商的名称：");
				String provider_name = Process.input();
				System.out.println("输入修改的供应商的地址：");
				String provider_add = Process.input();
				System.out.println("输入修改的供应商的电话：");
				String provider_tel = Process.input();
				System.out.println("输入修改的供应商的account:");
				String account = Process.input();
				System.out.println("输入修改的供应商的email:");
				String email = Process.input();
				ps.updateProviders(new Providers(providerID,provider_name, provider_add, provider_tel, account, email));
			}else if("4".equals(op)){
				List<Providers> list = ps.findAllProviders();
				for (Providers providers : list) {
					System.out.println(providers);
				}
			}else if("5".equals(op)){
				System.out.println("输入页数！！！");
				String currentPage = Process.input();
				int currentPage1 = Integer.parseInt(currentPage);
				System.out.println("输入每页显示条数！！！");
				String pageSize = Process.input();
				int pageSize1 = Integer.parseInt(pageSize);
				
				Page<Providers> page = ps.findtAllProvidersByPage(new Page<Providers>(currentPage1,pageSize1));
				List<Providers> list = page.getList();
				for (Providers a : list) {
					System.out.println(a);
				}
				
				while (true) {					
					
					System.out.println("1:首页     2:上一页   3：下一页   4：尾页    5：退出");
					
					String op1 = Process.input();
					if("1".equals(op1)){
						 int firstPage = page.firstPage();
						 Page<Providers> page2 = ps.findtAllProvidersByPage(new Page<Providers>(firstPage, pageSize1));
						 List<Providers> list2 = page2.getList();
						 for (Providers providers : list2) {
							System.out.println(providers);
						}
					}else if("2".equals(op1)){
						int upPage = page.getUpPage();
						 Page<Providers> page3 = ps.findtAllProvidersByPage(new Page<Providers>(upPage, pageSize1));
						 List<Providers> list3 = page3.getList();
						 for (Providers providers : list3) {
							System.out.println(providers);
						}
					}else if("3".equals(op1)){
						int nextPage = page.getNextPage();
						 Page<Providers> page4 = ps.findtAllProvidersByPage(new Page<Providers>(nextPage, pageSize1));
						 List<Providers> list4 = page4.getList();
						 for (Providers providers : list4) {
							System.out.println(providers);
						}
					}else if("4".equals(op1)){
						int lastPage = page.lastPage();
						 Page<Providers> page5 = ps.findtAllProvidersByPage(new Page<Providers>(lastPage, pageSize1));
						 List<Providers> list5 = page5.getList();
						 for (Providers providers : list5) {
							System.out.println(providers);
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
