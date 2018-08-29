package com.business.test;

import java.util.List;

import org.junit.Test;

import com.business.entity.Admin;
import com.business.entity.Products;
import com.business.entity.Providers;
import com.business.service.AdminService;
import com.business.service.ProductsService;
import com.business.service.ProviderService;
import com.business.util.Page;


public class TestAll {
	@Test
	public void testAdmin() {
		AdminService as = new AdminService();		
		String name = "admin";
		String password = "123456";
		Admin admin = as.findAdminByLogin(new Admin(name , password));
		System.out.println(admin);
		
	}
	@Test
	public void testAdminByPage() {
		AdminService as = new AdminService();
		int currentPage = 1;
		int pageSize = 5;
		
		Page<Admin> page = as.findAllAdminByPage(new Page<Admin>(currentPage,pageSize));
		System.out.println("当前第"+page.getCurrentPage()+"页");
		System.out.println("总共"+page.getTotalPage()+"页");
		List<Admin> list = page.getList();
		for(Admin a: list){
			System.out.println(a);
		}
		System.out.println("---下一页---");
		currentPage = page.getNextPage();
		Page<Admin> page2 = as.findAllAdminByPage(new Page<Admin>(currentPage,pageSize));
		System.out.println("当前第"+page2.getCurrentPage()+"页");
		System.out.println("总共"+page2.getTotalPage()+"页");
		List<Admin> list2 = page2.getList();
		for(Admin a: list2){
			System.out.println(a);
		}
	}
	
	
	@Test
	public void testProductsByPage() {
		ProductsService as = new ProductsService();
		int currentPage = 1;
		int pageSize = 5;
		
		Page<Products> page = as.findAllProductByPage(new Page<Products>(currentPage,pageSize));
		System.out.println("当前第"+page.getCurrentPage()+"页");
		System.out.println("总共"+page.getTotalPage()+"页");
		List<Products> list = page.getList();
		for(Products a: list){
			System.out.println(a);
		}
		System.out.println("---下一页---");
		currentPage = page.getNextPage();
		Page<Products> page2 = as.findAllProductByPage(new Page<Products>(currentPage,pageSize));
		System.out.println("当前第"+page2.getCurrentPage()+"页");
		System.out.println("总共"+page2.getTotalPage()+"页");
		List<Products> list2 = page2.getList();
		for(Products a: list2){
			System.out.println(a);
		}
	}
	
	@Test
	public void testProvidersByPage() {
		ProviderService as = new ProviderService();
		int currentPage = 1;
		int pageSize = 5;
		
		Page<Providers> page = as.findtAllProvidersByPage(new Page<Providers>(currentPage, pageSize));
		System.out.println("当前第"+page.getCurrentPage()+"页");
		System.out.println("总共"+page.getTotalPage()+"页");
		List<Providers> list = page.getList();
		for(Providers a: list){
			System.out.println(a);
		}
		System.out.println("---下一页---");
		currentPage = page.getNextPage();
		Page<Providers> page2 = as.findtAllProvidersByPage(new Page<Providers>(currentPage, pageSize));
		System.out.println("当前第"+page2.getCurrentPage()+"页");
		System.out.println("总共"+page2.getTotalPage()+"页");
		List<Providers> list2 = page2.getList();
		for(Providers a: list2){
			System.out.println(a);
		}
	}
	@Test
	public void testProvidersAdd() {
		ProviderService as = new ProviderService();		
		int providerID = 5;
		String provider_name = "aaa";
		String provider_add = "上哈";
		String provider_tel = "13278659843";
		String account = "A005";
		String email = "";
		boolean providers = as.addProviders(new Providers(providerID, provider_name, provider_add, provider_tel, account,email));
		System.out.println(providers);
		
	}
	
	@Test
	public void testProvidersDel() {
		int providerID = 5;		
		ProviderService as = new ProviderService();		
				
		boolean providers = as.removeProviders(new Providers(providerID));
		System.out.println(providers);
		
	}
	
	@Test
	public void testProvidersUp() {
		Providers as = new Providers(5,"bb","上海","13267458903","A005","109433009@qq.com");		
		ProviderService a = new ProviderService();	
		boolean ii = a.updateProviders(as);
		
		
		System.out.println(ii);
		
	}
	
	@Test
	public void testProvidersSelect() {
		
		ProviderService as = new ProviderService();	
		
		List<Providers> list = as.findAllProviders();
		for (Providers providers : list) {
			System.out.println(providers);
		}
		
	
		
	}
}
