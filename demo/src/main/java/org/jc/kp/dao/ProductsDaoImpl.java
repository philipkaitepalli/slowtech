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

/*	public void create(Products products) {
		// TODO Auto-generated method stub
		currentSession().saveOrUpdate(products);
		
	}

	public void update(Products products) {
		// TODO Auto-generated method stub
		currentSession().update(products);
		
	}

	public void delete(Integer pId) {
		// TODO Auto-generated method stub
		Products products = (Products) currentSession().load(
				Products.class, pId);
				currentSession().delete(products);		
				}
	
	

	public Products find(Integer pId) {
		// TODO Auto-generated method stub
		return (Products)currentSession().get(Products.class,pId);
	}

	@SuppressWarnings("unchecked")
	public List<Products> getAll() {
		// TODO Auto-generated method stub
		return (List<Products>)currentSession().createQuery("from Products").list();
	}

	public Products findBilling(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}*/
	

	public void create(Products products) {
		currentSession().saveOrUpdate(products);
	}

	
	public void update(Products products) {
		currentSession().update(products);
	}

	
	public void delete(Integer pId) {
				Products products = (Products) currentSession().load(
				Products.class, pId);
				currentSession().delete(products);		
				}
	
	public Products find(Integer pId) {
		
		return (Products)currentSession().get(Products.class,pId);
	}
	@SuppressWarnings({ "unchecked" })

		public List<Products> getAll() {
		
		return (List<Products>)currentSession().createQuery("from Products").list();
	}

	
	public Products findBilling(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
