package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.Carpenter;
import org.jc.kp.model.Customer;

public interface PreBillPickerService {
	 public List<Customer> searchCustomerFirstName(String ss);
	 public List<Customer> searchCustomerLastName(String ss);
	 
	 public List<Carpenter> searchCarpenterFirstName(String ss);
	 public List<Carpenter> searchCarpenterLastName(String ss);
	 
	 public Customer searchCustomer(Customer customer);
	 public Carpenter searchCarpenter(Carpenter carpenter);

}
