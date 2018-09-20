package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.CalService;
import org.jc.kp.model.Products;

public interface BillingService {
	 public List<Products> searchFp(String ss);
	 public List<Products> searchSp(String ss);
	 public Products searchProducts(CalService calService);
}
