package com.business.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.business.dao.AdminDao;
import com.business.entity.Admin;
import com.business.util.DBHelper;
import com.business.util.Page;

public class AdminService implements AdminServiceInterface{

	private AdminDao ad;
	public AdminService(){
		ad = new AdminDao();
	}
	@Override
	public Admin findAdminByLogin(Admin admin) {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		Admin temp = null;
		try {
			ResultSet set = ad.selectAdminByLogin(conn, admin);
			if(set.next()){
				int admin_id = set.getInt("admin_id");
				String admin_name = set.getString("admin_name");
				String admin_password = set.getString("admin_password");
				String date = set.getString("date");
				temp = new Admin(admin_id,admin_name,admin_password,date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ad.closeALL();
		}
		return temp;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		boolean f = false;
		Connection conn = DBHelper.getConnection();
		
		try {
			int i = ad.insertAdmin(conn, admin);
			if(i>0){
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ad.closeALL();
		}
		
		return f;
	}
	
	@Override
	public boolean removeAdmin(Admin admin) {
		Connection conn = DBHelper.getConnection();
		boolean f = false;
		try {
			int i = ad.deleteAdmin(conn, admin);
			if(i>0){
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ad.closeALL();
		}
		return f;
	}
	@Override
	public boolean updateAdmin(Admin admin) {
		Connection conn = DBHelper.getConnection();
		boolean f = false;
		try {
			int i = ad.updateAdmin(conn, admin);
			if(i>0){
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ad.closeALL();
		}
		return f;
	}

	@Override
	public List<Admin> findAllAdmin() {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		List<Admin> list  = new ArrayList<Admin>();
		try {
			ResultSet set = ad.selectAllAdmin(conn);
			while(set.next()){
				int admin_id = set.getInt("admin_id");
				String admin_name = set.getString("admin_name");
				String admin_password = set.getString("admin_password");
				String date = set.getString("date");
				list.add(new Admin(admin_id,admin_name,admin_password,date));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ad.closeALL();
		}
		return list;
		
	}
	
	
	
	@Override
	//调用方法的时候只有两个属性有值  currentPage ,   pageSize
	public Page<Admin> findAllAdminByPage(Page<Admin> page) {
		// TODO Auto-generated method stub
		//Page<Admin> temp = null;
		Connection conn = DBHelper.getConnection();
		List<Admin> list  = new ArrayList<Admin>();
		try {
			ResultSet set = ad.selectAllAdminByPage(conn, page);
			while(set.next()){
				int admin_id = set.getInt("admin_id");
				String admin_name = set.getString("admin_name");
				String admin_password = set.getString("admin_password");
				String date = set.getString("date");
				list.add(new Admin(admin_id,admin_name,admin_password,date));
			}
			//这个时候有三个属性有值
			page.setList(list);
			int allRecord = ad.getAllRecord(conn);
			//这个时候四个属性都有值
			page.setTotalRecord(allRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ad.closeALL();
		}
		//需要四个属性都有值
		return page;
		
	}


}
