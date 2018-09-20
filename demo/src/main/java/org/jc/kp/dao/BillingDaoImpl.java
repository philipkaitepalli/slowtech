package org.jc.kp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.CalService;
import org.jc.kp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class BillingDaoImpl implements BillingDao {
  
	@Autowired
	private	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
/*
	public List<Products> searchFp(String ss) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Products> searchSp(String ss) {
		// TODO Auto-generated method stub
		return null;
	}

	public Products searchProducts(CalService calService) {
		// TODO Auto-generated method stub
		return null;
	}
	
	*/
	
	
	
   @SuppressWarnings({ "unchecked" })
	
	public List<Products> searchFp(String ss) {
		String qr="select p.pStandurdDimension from Products p where p.pStandurdDimension like:name";
				try {
			return currentSession().createQuery(qr)
					.setParameter("name","%"+ss+"%")
					.list();
			 
		}catch(Exception e) {
			System.out.println("------"+e);
			return null;
		}
		
	}

	@SuppressWarnings({ "unchecked" })

	public List<Products> searchSp(String ss) {
		String qr="select p.pName from Products p where p.pName like:name";
		try {
	return currentSession().createQuery(qr)
			.setParameter("name","%"+ss+"%")
			.list();
	 
}catch(Exception e) {
	System.out.println("------"+e);
	return null;
}
	}

	public Products searchProducts(CalService calService) {
		Map<String, String> map=new HashMap<String, String>();
		String fp=calService.getFp();
		String sp=calService.getSp();
		map.put("fp",fp);
		map.put("sp",sp);
		String qr="select p from Products p where p.pStandurdDimension=:fp and p.pName=:sp ";
		try {
			return(Products)currentSession().createQuery(qr)
			.setProperties(map)
			.setMaxResults(1)
	         .uniqueResult();
	
}catch(Exception e) {
	System.out.println("------"+e);
	return null;
}
	}
	
	
}
