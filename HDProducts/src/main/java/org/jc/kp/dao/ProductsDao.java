package org.jc.kp.dao;

import java.util.List;

import org.jc.kp.model.Products;

public interface ProductsDao {
	
	    public void create(Products products);
	    public void update(Products products);
		public void delete(Integer pId);
		public Products find(Integer pId);
		public List<Products> getAll();
		public List<Products> search(String text);
		public Products findBilling(String pCode);
	//	public Products find(String pStandurdDimension,String pName);
	

}


