package org.jc.kp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    
	@Autowired
	private	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	/*public void create(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer customerId) {
		// TODO Auto-generated method stub
		
	}

	public Customer find(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	*/
	

	public void create(Customer customer) {
		currentSession().saveOrUpdate(customer);
		
	}

	
	public void update(Customer customer) {
		currentSession().update(customer);
		
	}

	
	public void delete(Integer customerId) {
		Customer customer = (Customer) currentSession().load(Customer.class, customerId);
		currentSession().delete(customer);
		
	}

	
	public Customer find(Integer customerId) {
		return (Customer)currentSession().get(Customer.class,customerId);
	}

	@SuppressWarnings("unchecked")
	
	public List<Customer> getAll() {
		return (List<Customer>)currentSession().createQuery("from Customer").list();
	}

}
