package org.jc.kp.service;

import java.util.List;

import org.jc.kp.dao.PreBillPickerDao;
import org.jc.kp.model.Carpenter;
import org.jc.kp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("preBillPickerService")
public class PreBillPickerServiceImpl implements PreBillPickerService {
	@Autowired
    private PreBillPickerDao preBillPickerDao;
	
//==============================Customer===============================================	
	
	public List<Customer> searchCustomerFirstName(String ss) {
		// TODO Auto-generated method stub
		return preBillPickerDao.searchCustomerFirstName(ss);
	}

	
	public List<Customer> searchCustomerLastName(String ss) {
		// TODO Auto-generated method stub
		return preBillPickerDao.searchCustomerLastName(ss);
	}
//===========================Carpenter=====================================================

	public List<Carpenter> searchCarpenterFirstName(String ss) {
		// TODO Auto-generated method stub
		return preBillPickerDao.searchCarpenterFirstName(ss);
	}

	
	public List<Carpenter> searchCarpenterLastName(String ss) {
		// TODO Auto-generated method stub
		return preBillPickerDao.searchCarpenterLastName(ss);
	}
//===========================getIds=========================================================

	public Customer searchCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return preBillPickerDao.searchCustomer(customer);
	}

	
	public Carpenter searchCarpenter(Carpenter carpenter) {
		// TODO Auto-generated method stub
		return preBillPickerDao.searchCarpenter(carpenter);
	}

}
