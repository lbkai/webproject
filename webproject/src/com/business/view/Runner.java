package com.business.view;

import java.util.List;

import org.junit.Test;

import com.business.entity.Admin;
import com.business.excepption.DuplicateValueException;
import com.business.excepption.NotNullException;
import com.business.excepption.ValueExistException;
import com.business.service.AdminService;

public class Runner {
	AdminService as = new AdminService();
	private AdminProcess ap;
	private ProductsProcess pdp;
	private ProviderProcess pvp;
	private CategoryProcess cp;

	public Runner() {
		ap = new AdminProcess();
		pdp = new ProductsProcess();
		pvp = new ProviderProcess();
		cp = new CategoryProcess();
	}

	@Test
	public void RunnerProcess() throws NotNullException {

		while (true) {
			System.out.println("1:登录     2：增加用户   3：退出");
			String op = Process.input();

			try {
				if ("1".equals(op)) {
					System.out.println("输入用户名！！！");
					String admin_name = Process.input();
					System.out.println("输入密码！！！");
					String admin_password = Process.input();
					Admin admin = as.findAdminByLogin(new Admin(admin_name, admin_password));
					if (admin == null) {
						throw new ValueExistException();
					}


					while (true) {
						System.out.println("1:对Admin表的操作    2：对Products表的操作      3：对Providers表的操作    4：对Categorys表的操作     5：退出");
						String op2 = Process.input();
						if ("1".equals(op2)) {
							try {
								ap.process();
							} catch (ValueExistException e) {
								// TODO Auto-generated catch block
								// e.printStackTrace();
								System.out.println("ID不存在！！");
							}
						} else if ("2".equals(op2)) {
							try {
								pdp.process();
							} catch (ValueExistException e) {
								// TODO Auto-generated catch block
								// e.getMessage();
								System.out.println("ID不存在！！");
							} catch (NotNullException e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
								System.out.println("字符不能为空!!");
							}
						} else if ("3".equals(op2)) {
							try {
								pvp.process();
							} catch (NotNullException e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
								System.out.println("字符不能为空!!");
							}
						} else if ("4".equals(op2)) {
							try {
								cp.process();
							} catch (NotNullException e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
								System.out.println("字符不能为空!!");
							}
						} else if ("5".equals(op2)) {
							break;
						}
					}

				} else if ("2".equals(op)) {
					try {
						System.out.println("添加用户名！！！");
						String admin_name = Process.input();
//						if(admin_name.equals("") ) {
//							throw new NotNullException();
//						}
						if(admin_name.trim().length()==0){
							throw new NotNullException();
						}
						/**
						 * 判断admin_name是否相同
						 */					
	
						List<Admin> list = as.findAllAdmin();
						for (Admin admin : list) {
							if(admin.getAdmin_name().equals(admin_name)){								
							    throw new DuplicateValueException();						     		
							}
						}
						System.out.println("添加用户密码！！！");
						String admin_password = Process.input();
						as.addAdmin(new Admin( admin_name, admin_password));
						System.out.println("添加成功！！");
						
					} catch (NotNullException  e) {
						
						System.out.println("输入的字符为空！！");
					} catch (DuplicateValueException e) {
						// TODO Auto-generated catch block
						System.out.println("用户名重复了！！");
					}

				} else if ("3".equals(op)) {
					break;

				}
			} catch (NumberFormatException e) {
				System.out.println("数字格式异常！！！");
			} catch (ValueExistException e) {
				System.out.println("用户名或密码不正确！！！");
			}
		}

	}
}
