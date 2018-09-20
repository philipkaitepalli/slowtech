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
	
	@Override
	public void create(Carpenter carpenter) {
		currentSession().saveOrUpdate(carpenter);
		
	}

	@Override
	public void update(Carpenter carpenter) {
		currentSession().update(carpenter);
		
	}

	@Override
	public void delete(Integer carpId) {
		Carpenter carpenter = (Carpenter)currentSession().load(Carpenter.class, carpId);
		currentSession().delete(carpenter);	
		
	}

	@Override
	public Carpenter find(Integer carpId) {
		return (Carpenter)currentSession().get(Carpenter.class,carpId);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carpenter> getAll() {
		return (List<Carpenter>)currentSession().createQuery("from Carpenter").list();
		
	}

}
