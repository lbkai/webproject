package com.business.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.business.entity.Providers;
import com.business.util.Page;

public interface ProvidersDaoInterface {
	// 新增
	public int insertProviders(Connection conn, Providers providers) throws SQLException;

	// 删除
	public int deleteProviders(Connection conn, int pvid) throws SQLException;

	// 修改
	public int updateProviders(Connection conn, Providers providers) throws SQLException;

	// 查询所有
	public ResultSet selectAllProviders(Connection conn) throws SQLException;

	// 通过主键查询
	public ResultSet selectProvidersById(Connection conn) throws SQLException;

	// 查询admin分页
	public ResultSet selectAllProvidersByPage(Connection conn, Page<Providers> page) throws SQLException;

	// 查询得到总记录数totalRecord Page类中
	public int getAllRecord(Connection conn) throws SQLException;
}
