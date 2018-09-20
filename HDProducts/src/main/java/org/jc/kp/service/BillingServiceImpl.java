package org.jc.kp.service;

import java.util.List;

import org.jc.kp.dao.BillingDao;
import org.jc.kp.model.CalService;
import org.jc.kp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("BillingService")
public class BillingServiceImpl implements BillingService {

	
	@Autowired
    private	BillingDao billingDao;
	@Override
	public List<Products> searchFp(String ss) {
		
		return billingDao.searchFp(ss);
	}
	@Override
	public List<Products> searchSp(String ss) {
		// TODO Auto-generated method stub
		return  billingDao.searchSp(ss);
	}
	@Override
	public Products searchProducts(CalService calService) {
		// TODO Auto-generated method stub
		return billingDao.searchProducts(calService);
	}

}
