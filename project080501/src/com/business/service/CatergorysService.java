package com.business.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.business.dao.CatergorysDao;
import com.business.entity.Categorys;
import com.business.util.DBHelper;
import com.business.util.Page;

public class CatergorysService implements CategorysServiceInterface {

	private CatergorysDao cd;
	public CatergorysService(){
		cd = new CatergorysDao();
	}
	@Override
	public boolean addCategorys(Categorys categorys) {
		
		boolean f = false;
		Connection conn = DBHelper.getConnection();
		try {
			int i = cd.insertCategorys(conn, categorys);
			if(i>0){
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean removeCategorys(Categorys categorys) {

		boolean f = false;
		Connection conn = DBHelper.getConnection();
		try {
			int i = cd.deleteCategorys(conn, categorys);
			if(i>1){
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updateCategorys(Categorys categorys) {
		boolean f = false;
		Connection conn = DBHelper.getConnection();
		
		try {
			int i = cd.updateCategorys(conn, categorys);
			if(i>1){
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Categorys> findAllCategorys() {

		Connection conn = DBHelper.getConnection();
		List<Categorys> list = new ArrayList<Categorys>();
		
		try {
			ResultSet set = cd.selectAllCategorys(conn);
			while(set.next()){
				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String category_desc = set.getString("category_desc");
				list.add(new Categorys(categoryID, category_name, category_desc));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cd.closeALL();
		}
		return list;
	}

	@Override
	public Page<Categorys> findtAllCategorysByPage(Page<Categorys> page) {
		Connection conn = DBHelper.getConnection();
		List<Categorys> list = new ArrayList<Categorys>();
		try {
			ResultSet set = cd.selectAllCategorysByPage(conn, page);
			while(set.next()){
				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String category_desc = set.getString("category_desc");
				
				list.add(new Categorys(categoryID, category_name, category_desc));
			}
			//这时候有三个属性值
			page.setList(list);
			//第四个属性值
			int allRecord = cd.getAllRecord(conn);
			page.setTotalRecord(allRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cd.closeALL();
		}
		
		return page;
	}

}
