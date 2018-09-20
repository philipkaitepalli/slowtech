
package org.jc.kp.service;

import java.util.List;



import org.jc.kp.dao.ProductsDao;
import org.jc.kp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
    
	@Autowired
     private ProductsDao productsDao;
	

	public void create(Products products) {
		// TODO Auto-generated method stub
		productsDao.create(products);
	}

	public void update(Products products) {
		// TODO Auto-generated method stub
		productsDao.update(products);
	}

	public void delete(Integer pId) {
		// TODO Auto-generated method stub
		productsDao.delete(pId);
	}

	public Products find(Integer pId) {
		// TODO Auto-generated method stub
		return productsDao.find(pId);
	}

	public List<Products> getAll() {
		// TODO Auto-generated method stub
		return productsDao.getAll();
	}

	public Products findBilling(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}	




