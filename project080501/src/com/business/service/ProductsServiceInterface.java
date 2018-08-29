package com.business.service;

import java.util.List;

import com.business.entity.Products;
import com.business.util.Page;

public interface ProductsServiceInterface {
	
	public List<Products> findAllProducts();

	public Page<Products> findAllProductByPage(Page<Products> page);
	
	
}
