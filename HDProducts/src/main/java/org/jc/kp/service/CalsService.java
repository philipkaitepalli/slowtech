package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.CalService;
import org.jc.kp.model.Products;

public interface CalsService {
	public CalService add(CalService calService);
	public CalService mult(Products products,CalService calService);
	public CalService mult(List<Products> list,CalService calService);
	public CalService sub(Float pp);
	public CalService dive(Float pp);

}
