package org.jc.kp.dao;

import java.util.List;

import org.jc.kp.model.Customer;

public interface CustomerDao {
	
	public void create(Customer customer);
    public void update(Customer customer);
	public void delete(Integer customerId);
	public Customer find(Integer customerId);
	public List<Customer> getAll();

}
