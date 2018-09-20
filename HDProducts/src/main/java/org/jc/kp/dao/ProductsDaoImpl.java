package org.jc.kp.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductsDaoImpl implements ProductsDao {
	
	@Autowired
	private	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Products products) {
		currentSession().saveOrUpdate(products);
	}

	@Override
	public void update(Products products) {
		currentSession().update(products);
	}

	@Override
	public void delete(Integer pId) {
				Products products = (Products) currentSession().load(
				Products.class, pId);
				currentSession().delete(products);		
				}
	
	public Products find(Integer pId) {
		
		return (Products)currentSession().get(Products.class,pId);
	}
	@SuppressWarnings({ "unchecked" })
	@Override
		public List<Products> getAll() {
		
		return (List<Products>)currentSession().createQuery("from Products").list();
	}
	
	
     @SuppressWarnings("unchecked")
	public List<Products> search(String text) {
    	 String sql="FROM Products WHERE (pName LIKE '%"+text+"%' OR pCompanyName LIKE '%"+text+"%' OR pStandurdDimension LIKE '%"+text+"%' OR pUnitType LIKE '%"+text+"%')";
		return (List<Products>)currentSession().createQuery(sql).list();
	}
     
     
	@Override
	public Products findBilling(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
