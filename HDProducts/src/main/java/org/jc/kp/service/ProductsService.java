package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.Products;

public interface ProductsService {
	    public void create(Products products);
	    public void update(Products products);
		public void delete(Integer pId);
		public Products find(Integer pId);
		//public Products find(String pStandurdDimension,String pName);
		public List<Products> getAll();
		public List<Products> search(String text);
		public Products findBilling(String pCode);
		
		
		
}

