package org.jc.kp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.Bill_Id_Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class Bill_Id_GeneratorDaoImpl implements Bill_Id_GeneratorDao {
	@Autowired
	private	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
/*
	public void create(Bill_Id_Generator bill_Id_Generator) {
		// TODO Auto-generated method stub
		
	}

	public void update(Bill_Id_Generator bill_Id_Generator) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer pId) {
		// TODO Auto-generated method stub
		
	}

	public Bill_Id_Generator find(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bill_Id_Generator> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	*/
	
	public void create(Bill_Id_Generator bill_Id_Generator) {
		// TODO Auto-generated method stub
	currentSession() .saveOrUpdate(bill_Id_Generator);
	}

	

	
	public void delete(Integer pId) {
		// TODO Auto-generated method stub
		currentSession().delete(pId); 
	}

	
	public Bill_Id_Generator find(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Bill_Id_Generator> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void update(Bill_Id_Generator bill_Id_Generator) {
		// TODO Auto-generated method stub
		
	}

}
