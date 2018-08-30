package com.business.service;

import java.util.List;

import com.business.entity.Admin;
import com.business.util.Page;

public interface AdminServiceInterface {

	//登录
	public Admin findAdminByLogin(Admin admin);
	//新增
	public boolean addAdmin(Admin admin);
	//删除
	public boolean removeAdmin(Admin admin);
	//修改
	public boolean updateAdmin(Admin admin);
	//查询所有
	public List<Admin> findAllAdmin();
	//查询所有分页
	public Page<Admin> findAllAdminByPage(Page<Admin> page);
}

