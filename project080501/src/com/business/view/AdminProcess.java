package com.business.view;

import java.util.List;

import org.junit.Test;

import com.business.entity.Admin;
import com.business.service.AdminService;
import com.business.util.Page;

public class AdminProcess {

	 AdminService as = new AdminService();
	

	@Test
	public  void process() {
		while (true) {
			System.out.println("1:登录     2：增加用户   3:删除用户      4:修改用户  5：查找所有       6：分页查找       7：退出");
			String op = Process.input();
			if ("1".equals(op)) {
				
				System.out.println("输入用户名！！！");
				String admin_name = Process.input();
				System.out.println("输入密码！！！");
				String admin_password = Process.input();
				as.findAdminByLogin(new Admin(admin_name, admin_password));
			} else if ("2".equals(op)) {
				System.out.println("添加用户名！！！");
				String admin_name = Process.input();
				System.out.println("添加用户密码！！！");
				String admin_password = Process.input();
				as.addAdmin(new Admin(admin_name, admin_password));
			}else if("3".equals(op)){
				System.out.println("输入要删除用户的id");
				String admin_id = Process.input();
				int adminid = Integer.parseInt(admin_id);
				as.removeAdmin(new Admin(adminid));
				
			}else if("4".equals(op)){
				System.out.println("输入要修改的id：");
				String admin_id = Process.input();
				int adminid = Integer.parseInt(admin_id);
				System.out.println("用户名改为：");
				String admin_name = Process.input();
				System.out.println("密码改为:");
				String admin_password = Process.input();
				System.out.println("时间改为:");
				String date = Process.input();
				as.updateAdmin(new Admin(adminid, admin_name, admin_password, date));
			}else if ("5".equals(op)) {
				List<Admin> list = as.findAllAdmin();
				for (Admin admin : list) {
					System.out.println(admin);
				}
			} else if ("6".equals(op)) {
				System.out.println("输入页数！！！");
				String currentPage = Process.input();
				int currentPage1 = Integer.parseInt(currentPage);
				System.out.println("输入每页显示条数！！！");
				String pageSize = Process.input();
				int pageSize1 = Integer.parseInt(pageSize);
				Page<Admin> page = as.findAllAdminByPage(new Page<Admin>(currentPage1, pageSize1));
				List<Admin> list = page.getList();
				for (Admin a : list) {
					System.out.println(a);
				}
				
				while (true) {					
					
					System.out.println("1:首页     2:上一页   3：下一页   4：尾页    5：退出");
					
					String op1 = Process.input();
					if("1".equals(op1)){
						 int firstPage = page.firstPage();
						 Page<Admin> page2 = as.findAllAdminByPage(new Page<Admin>(firstPage, pageSize1));
						 List<Admin> list2 = page2.getList();
						 for (Admin admin : list2) {
							System.out.println(admin);
						}
					}else if("2".equals(op1)){
						int upPage = page.getUpPage();
						 Page<Admin> page3 = as.findAllAdminByPage(new Page<Admin>(upPage, pageSize1));
						 List<Admin> list3 = page3.getList();
						 for (Admin admin : list3) {
							System.out.println(admin);
						}
					}else if("3".equals(op1)){
						int nextPage = page.getNextPage();
						 Page<Admin> page4 = as.findAllAdminByPage(new Page<Admin>(nextPage, pageSize1));
						 List<Admin> list4 = page4.getList();
						 for (Admin admin : list4) {
							System.out.println(admin);
						}
					}else if("4".equals(op1)){
						int lastPage = page.lastPage();
						 Page<Admin> page5 = as.findAllAdminByPage(new Page<Admin>(lastPage, pageSize1));
						 List<Admin> list5 = page5.getList();
						 for (Admin admin : list5) {
							System.out.println(admin);
						}
					}else if("5".equals(op1)){
						break;
					}
				}

			} else if ("7".equals(op)) {
				break;
			}
		}

	}
}