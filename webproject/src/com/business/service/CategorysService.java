package com.business.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.business.dao.CatergorysDao;
import com.business.dao.ProductsDao;
import com.business.entity.Categorys;
import com.business.entity.Products;
import com.business.util.DBHelper;
import com.business.util.Page;

public class CategorysService implements CategorysServiceInterface {

	private CatergorysDao cd;
	private ProductsDao pd;
	public CategorysService(){
		cd = new CatergorysDao();
		pd = new ProductsDao();
	}
	@Override
	public boolean addCategorys(Categorys categorys) {
		
		boolean f = false;
		Connection conn = DBHelper.getConnection();
		try {
			int i = cd.insertCategorys(conn, categorys);
			if(i>0){
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cd.closeALL();
		}
		return f;
	}
	
public int addCategorysByName(Categorys categorys) {

		Connection conn = DBHelper.getConnection();
		try {
			ResultSet set = cd.selectCategoryByName(conn, categorys.getCategory_name());
			if(!set.next()) {
				return cd.insertCategorys(conn, categorys);			
			}else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cd.closeALL();
		}
		return 0;
	}
	
	@Override
	public int removeCategorysByCid(int cid) {
		Connection conn = DBHelper.getConnection();
		try {
			ResultSet set = pd.selecProductsByCid(conn, cid);
			if(set.next()){
				return -1;
			}else{
				conn.setAutoCommit(false);
				int i = cd.deleteCategorysByCid(conn, cid);
				conn.commit();
				conn.setAutoCommit(true);
				return i ;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}finally{
			cd.closeALL();
			pd.closeALL();
		}
		return 0;
	}
	

	@Override
	public boolean updateCategorys(Categorys categorys) {
		boolean f = false;
		Connection conn = DBHelper.getConnection();
		
		try {
			int i = cd.updateCategorys(conn, categorys);			
			if(i>0){
				 f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cd.closeALL();
		}
		return f;
	}
	
	//修改时验证名称的重名问题
	public int updateCategorysByName(Categorys categorys) {
		Connection conn = DBHelper.getConnection();		
		try {
			ResultSet set = cd.selectCategoryByName(conn, categorys.getCategory_name());
			if(set.next()) {
				return cd.updateCategorys(conn, categorys);							
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cd.closeALL();
		}
		return 0;
	}

	public int modifyCategory(Categorys c) {
		Connection conn = DBHelper.getConnection();
		try {
			return cd.updateCategorys(conn, c);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			cd.closeALL();
		}
		return 0;
	}
	
	@Override
	public List<Categorys> findAllCategorys() {

		Connection conn = DBHelper.getConnection();
		List<Categorys> list = new ArrayList<Categorys>();
		ResultSet set;
		try {
			 set = cd.selectAllCategorys(conn);
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
	
	//通过id查找
	@Override
	public Categorys findCategoryById(int id) {

		Connection conn = DBHelper.getConnection();
		
		ResultSet set;
		try {
			 set = cd.selectCategoryById(conn, id);
			if(set.next()){
				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String category_desc = set.getString("category_desc");
				return new Categorys(categoryID, category_name, category_desc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cd.closeALL();
		}
		return null;
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
