package com.business.service;

import com.business.entity.Products;
import com.business.util.Page;

public interface ProductsServiceInterface {

	public Page<Products> findAllProductByPage(Page<Products> page);
	
	
}
