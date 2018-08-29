package com.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Providers;
import com.business.util.Page;

public class ProvidersDao extends BaseDao implements ProvidersDaoInterface {

	@Override
	public int insertProviders(Connection conn, Providers providers) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into providers(providerID,provider_name,provider_add,provider_tel,account,email) values(?,?,?,?,?,?)";
		Object[] objs = { providers.getProviderID(), providers.getProvider_name(), providers.getProvider_add(),
				providers.getProvider_tel(), providers.getAccount(), providers.getEmail() };

		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int deleteProviders(Connection conn, Providers providers) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete  from providers where providerID = ? ";
		Object[] objs = {providers.getProviderID()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int updateProviders(Connection conn, Providers providers) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update providers set  provider_name = ? , provider_add = ? , provider_tel = ? , account = ? , email = ? where providerID = ? ";
		Object[] objs = {  providers.getProvider_name(), providers.getProvider_add(),providers.getProvider_tel(), providers.getAccount(), providers.getEmail(),providers.getProviderID() };
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public ResultSet selectAllProviders(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from providers";
		return super.selectDate(conn, sql, null);
	}
	@Override
	public ResultSet selectProvidersById(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from providers where ";
		return null;
	}
	@Override
	public ResultSet selectAllProvidersByPage(Connection conn, Page<Providers> page) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from providers limit ? , ?";

		Object[] objs = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
		return super.selectDate(conn, sql, objs);
	}

	@Override
	public int getAllRecord(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
			int i = 0;
			String sql = "select count(*) from providers";
			ResultSet set = super.selectDate(conn, sql, null);
			if(set.next()){
				i = set.getInt(1);//1是显示第一列
			}
			return i;
		}


	

}
