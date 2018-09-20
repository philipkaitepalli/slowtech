
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
	
	@Override
	public void create(Products products) {
		productsDao.create(products);
	}
	@Override
	public void update(Products products) {
		productsDao.update(products);
	}
	/*@Override
	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}*/

	@Override
	public void delete(Integer pId) {
			productsDao.delete(pId);
	}

	@Override
	public Products find(Integer pId) {
		
		return productsDao.find(pId);
	}

	@Override
	public List<Products> getAll() {
    		return productsDao.getAll();
	}
	@Override
	public Products findBilling(String pCode) {
		return productsDao.findBilling(pCode);
		}
	@Override
	public List<Products> search(String text) {
		// TODO Auto-generated method stub
		return productsDao.search(text);
	}


	

	
}	




