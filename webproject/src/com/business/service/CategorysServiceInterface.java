package com.business.service;

import java.util.List;

import com.business.entity.Categorys;
import com.business.util.Page;

public interface CategorysServiceInterface {
	// 新增
	public boolean addCategorys(Categorys categorys);

	// 删除
	public int removeCategorysByCid(int	 cid);

	// 修改
	public boolean updateCategorys(Categorys categorys);

	// 查询所有
	public List<Categorys> findAllCategorys();

	// 通过id查询
	public Categorys findCategoryById(int id);
	// 查询admin分页
	public Page<Categorys> findtAllCategorysByPage(Page<Categorys> page);

}
