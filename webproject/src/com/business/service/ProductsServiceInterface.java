package com.business.service;

import java.util.List;

import com.business.entity.Products;
import com.business.util.Page;

public interface ProductsServiceInterface {
	//增加
	public boolean addProducts(Products products); 
	//删除
	public boolean removeProducts(Products products );
	//通过id删除
	public boolean removeProductsById(int id );
	//修改
	public boolean updateProducts(Products products);
	//查找
	public List<Products> findAllProducts();
	//分页  查找
	public Page<Products> findAllProductByPage(Page<Products> page);
	/**
	 * 验证providers数据是否可以删除
	 */
	public List<Products> findAllProductsByPvid(int providerID);
	/**
	 * 验证categorys数据是否可以删除
	 */
	public List<Products> findAllProductsBypvidCid(int categoryID);
	//通过id查找
	public Products findProductById(int id);
}
