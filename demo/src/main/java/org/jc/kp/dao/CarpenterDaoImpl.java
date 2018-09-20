package org.jc.kp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.Carpenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class CarpenterDaoImpl implements CarpenterDao {
	@Autowired
	private	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
/*
	public void create(Carpenter carpenter) {
		// TODO Auto-generated method stub
		
	}

	public void update(Carpenter carpenter) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer pId) {
		// TODO Auto-generated method stub
		
	}

	public Carpenter find(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Carpenter> getAll() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	

	public void create(Carpenter carpenter) {
		currentSession().saveOrUpdate(carpenter);
		
	}


	public void update(Carpenter carpenter) {
		currentSession().update(carpenter);
		
	}


	public void delete(Integer carpId) {
		Carpenter carpenter = (Carpenter)currentSession().load(Carpenter.class, carpId);
		currentSession().delete(carpenter);	
		
	}


	public Carpenter find(Integer carpId) {
		return (Carpenter)currentSession().get(Carpenter.class,carpId);
		
	}

	@SuppressWarnings("unchecked")
	
	public List<Carpenter> getAll() {
		return (List<Carpenter>)currentSession().createQuery("from Carpenter").list();
		
	}

}
