package com.business.service;

import java.util.List;

import com.business.entity.Providers;
import com.business.util.Page;

public interface ProviderServiceInterface {
	// 新增
	public boolean addProviders(Providers providers);

	// 删除
	public boolean removeProviders(Providers providers);

	// 修改
	public boolean updateProviders(Providers providers);

	// 查询所有
	public List<Providers> findAllProviders();

	// 查询admin分页
	public Page<Providers> findtAllProvidersByPage(Page<Providers> page) ;

	// 查询得到总记录数totalRecord Page类中
	//public int getAllRecord() ;
}
