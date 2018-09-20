package org.jc.kp.service;

import java.util.List;

import org.jc.kp.dao.CustomerDao;
import org.jc.kp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
    private	CustomerDao customerDao;
	
	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
		
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	@Override
	public void delete(Integer customerId) {
		customerDao.delete(customerId);
		
	}

	@Override
	public Customer find(Integer customerId) {
		return customerDao.find(customerId);
	}

	@Override
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

}
