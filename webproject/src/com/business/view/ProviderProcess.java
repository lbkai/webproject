package com.business.view;

import java.util.List;

import org.junit.Test;

import com.business.dao.ProductsDao;
import com.business.entity.Products;
import com.business.entity.Providers;
import com.business.excepption.DateExistException;
import com.business.excepption.NotNullException;
import com.business.excepption.ValueExistException;
import com.business.service.ProductsService;
import com.business.service.ProviderService;
import com.business.util.Page;

public class ProviderProcess {
	ProviderService ps = new ProviderService();
	ProductsService pss = new ProductsService();	
	
	
	/**
	 * 判断ProviderID是否存在
	 * @param providerID
	 * @throws ValueExistException
	 */
	public void checkProviderID(int providerID) throws ValueExistException{
//		List<Providers> list = ps.findAllProviders();
//		for (Providers providers : list) {
//			if(providers.getProviderID() == providerID){
//				throw new ValueExistException();
//			}}
//		}
		for(int i = 0; i<ps.findAllProviders().size();i++){
			
			if(!(ps.findAllProviders().get(i).getProviderID() == providerID) && i == ps.findAllProviders().size()-1){
				throw new ValueExistException();
			}
		}
	}
	@Test
	public void checkProductsDate(int providerID) throws DateExistException {
		List<Products> list = pss.findAllProductsByPvid(providerID);		
			if(list.size() != 0){
				throw new DateExistException();										
		}
	}
	@Test
	public void process() throws  NotNullException{
		List<Providers> li = ps.findAllProviders();
		while(true){
			try{
			System.out.println("1:增加供应商   2:删除供应商      3：修改供应商  4：查供应商     5:分页查找   6：退出");
			String op = Process.input();
			if("1".equals(op)){
				System.out.println("输入供应商的名称：");
				String provider_name = Process.input();
				
				if(provider_name.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				for (Providers providers : li) {
					if(providers.getProvider_name().equals(provider_name)){
						throw new ValueExistException();
					}					
				}
				System.out.println("输入供应商的地址：");
				String provider_add = Process.input();
				if(provider_add.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				System.out.println("输入供应商的电话：");
				String provider_tel = Process.input();
				if(provider_tel.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				System.out.println("输入供应商的account:");
				String account = Process.input();
				if(account.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				System.out.println("输入供应商的email:");
				String email = Process.input();
				if(email.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				ps.addProviders(new Providers(provider_name, provider_add, provider_tel, account, email));
				System.out.println("添加成功！！");
				
			}else if("2".equals(op)){
				System.out.println("输入要删除供应商的id:");
				String providerid = Process.input();
				int providerID = Integer.parseInt(providerid);
				    checkProductsDate(providerID);
				    checkProviderID(providerID);
				    ps.removeProvidersByPvid(providerID);
				    System.out.println("删除成功！！");
			}else if("3".equals(op)){
				System.out.println("输入要修改供应商的id:");
				String providerid = Process.input();
				int providerID = Integer.parseInt(providerid);	
				checkProviderID(providerID);
				
				
				System.out.println("输入修改的供应商的名称：");
				String provider_name = Process.input();
				if(provider_name.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				for (Providers providers : li) {
					if(providers.getProvider_name().equals(provider_name)){
						throw new ValueExistException();
					}					
				}
				
				System.out.println("输入修改的供应商的地址：");
				String provider_add = Process.input();
				if(provider_add.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				System.out.println("输入修改的供应商的电话：");
				String provider_tel = Process.input();
				if(provider_tel.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				System.out.println("输入修改的供应商的account:");
				String account = Process.input();
				if(account.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				System.out.println("输入修改的供应商的email:");
				String email = Process.input();
				if(email.replaceAll(" ", "").length() == 0){
					throw new NotNullException();			
			      }
				ps.updateProviders(new Providers(providerID,provider_name, provider_add, provider_tel, account, email));
			    
				System.out.println("修改成功！！");
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
		}catch(NumberFormatException e){
			System.out.println("数字格式异常！！");
		}catch (DateExistException e) {
			// TODO Auto-generated catch block
			System.out.println("数据存在，不能删除！！");
		}catch (ValueExistException e) {
			// TODO Auto-generated catch block
			System.out.println("ID不存在！！");
		} 
		}
	}
	
}
