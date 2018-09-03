package com.business.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.business.dao.ProductsDao;
import com.business.dao.ProvidersDao;
import com.business.entity.Providers;
import com.business.util.DBHelper;
import com.business.util.Page;

public class ProviderService implements ProviderServiceInterface {

	private ProvidersDao pd;
	private ProductsDao prd ;
	public ProviderService(){
		pd = new ProvidersDao();
		prd = new ProductsDao();
	}
	@Override
	public boolean addProviders(Providers providers) {
		// TODO Auto-generated method stub
		boolean f = false;
		Connection conn = DBHelper.getConnection();
		try {
			int i = pd.insertProviders(conn, providers);
			if(i>0){
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		
		return f;		
	}

	@Override
	public int removeProvidersByPvid(int pvid) {
		// TODO Auto-generated method stub
		
		Connection conn = DBHelper.getConnection();
		try {
			//删除供应商之前做校验，校验供应商下是否有产品
			ResultSet set = prd.selecProductsByPvid(conn, pvid);
			if(set.next()){
				return -1;
				//目录下没有产品才可以删除
			}else {
				conn.setAutoCommit(false);
				  int i = pd.deleteProviders(conn, pvid);
				  conn.commit();
				  conn.setAutoCommit(true);
				  return i ;
				
			}
		} catch (SQLException e1) {
			try {
				conn.rollback();
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e1.printStackTrace();
		}finally{
			prd.closeALL();
			pd.closeALL();
		}
		return 0;
		
		
			
	}
	
	

	@Override
	public boolean updateProviders(Providers providers) {
		// TODO Auto-generated method stub
		boolean f = false;
		Connection conn = DBHelper.getConnection();
		try {
			int i = pd.updateProviders(conn, providers);
			if(i>0){
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		
		return f;		
	
	}

	@Override
	public List<Providers> findAllProviders() {
		// TODO Auto-generated method stub
			Connection conn = DBHelper.getConnection();
			List<Providers> list  = new ArrayList<Providers>();
			try {
				ResultSet set = pd.selectAllProviders(conn);
				while(set.next()){
					int providerID = set.getInt("providerID");
					String provider_name = set.getString("provider_name");
					String provider_add = set.getString("provider_add");
					String provider_tel = set.getString("provider_tel");
					String account = set.getString("account");
					String email = set.getString("email");
					list.add(new Providers(providerID, provider_name, provider_add, provider_tel, account, email));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				pd.closeALL();
			}
			return list;			
	}

	@Override
	public Page<Providers> findtAllProvidersByPage(Page<Providers> page) {
		// TODO Auto-generated method stub
		Connection conn = DBHelper.getConnection();
		List<Providers> list  = new ArrayList<Providers>();
		try {
			ResultSet set = pd.selectAllProvidersByPage(conn, page);
			while(set.next()){
				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				String provider_add = set.getString("provider_add");
				String provider_tel = set.getString("provider_tel");
				String account = set.getString("account");
				String email = set.getString("email");
				list.add(new Providers(providerID, provider_name, provider_add, provider_tel, account, email));
			}
			//这个时候有三个属性有值
			page.setList(list);
			int allRecord = pd.getAllRecord(conn);
			//这个时候四个属性都有值
			page.setTotalRecord(allRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pd.closeALL();
		}
		//需要四个属性都有值
		return page;
	}

}
