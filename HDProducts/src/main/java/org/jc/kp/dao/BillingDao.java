package org.jc.kp.dao;

import java.util.List;

import org.jc.kp.model.CalService;
import org.jc.kp.model.Products;

public interface BillingDao {
	 public List<Products> searchFp(String ss);
	 public List<Products> searchSp(String ss);
	 public Products searchProducts(CalService calService);
	 
}
