package org.jc.kp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.Carpenter;
import org.jc.kp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PreBillPickerDaoImpl implements PreBillPickerDao {
	@Autowired
	private	SessionFactory sessionFactory;
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
//===================================Customer===custFirstName======custLastName===============================================	
	@SuppressWarnings("unchecked")
	public List<Customer> searchCustomerFirstName(String ss) {
		String qr="select p.custFirstName from Customer p where p.custFirstName like:name";
		try {
	return currentSession().createQuery(qr)
			.setParameter("name","%"+ss+"%")
			.list();
}catch(Exception e) {
	System.out.println("------"+e);
	return null;
}
	}

	@SuppressWarnings("unchecked")
	public List<Customer> searchCustomerLastName(String ss) {
		String qr="select p.custLastName from Customer p where p.custLastName like:name";
		try {
	return currentSession().createQuery(qr)
			.setParameter("name","%"+ss+"%")
			.list();
}catch(Exception e) {
	System.out.println("------"+e);
	return null;
}
	}
//=============================carpFirstName=======carpLastName=======Carpenter======================================================
	@SuppressWarnings("unchecked")
	public List<Carpenter> searchCarpenterFirstName(String ss) {
		String qr="select p.carpFirstName from Carpenter p where p.carpFirstName like:name";
		try {
	return currentSession().createQuery(qr)
			.setParameter("name","%"+ss+"%")
			.list();
}catch(Exception e) {
	System.out.println("------"+e);
	return null;
}
		
	}

	@SuppressWarnings("unchecked")
	public List<Carpenter> searchCarpenterLastName(String ss) {
		String qr="select p.carpLastName from Carpenter p where p.carpLastName like:name";
		try {
	return currentSession().createQuery(qr)
			.setParameter("name","%"+ss+"%")
			.list();
}catch(Exception e) {
	System.out.println("------"+e);
	return null;
}
	}
//=====================================================================================================
	public Customer searchCustomer(Customer customer) {
		Map<String, String> map=new HashMap<String, String>();
		String fn=customer.getCustFirstName();
		String ln=customer.getCustLastName();
		System.out.println(fn+"....Customer..cu.."+ln);
		map.put("fn",fn);
		map.put("ln",ln);
		String qr="select p from Customer p where p.custFirstName=:fn and p.custLastName=:ln  ";
			Customer culist=(Customer)currentSession().createQuery(qr)
			.setProperties(map)
			.uniqueResult();
			return culist;
	}

	public Carpenter searchCarpenter(Carpenter carpenter) {
		Map<String, String> map=new HashMap<String, String>();
		String fn=carpenter.getCarpFirstName();
		String ln=carpenter.getCarpLastName();
		System.out.println(fn+"....Carpenter...."+ln);
		map.put("fn",fn);
		map.put("ln",ln);
		String qr="select p from Carpenter p where p.carpFirstName=:fn and p.carpLastName=:ln ";
			Carpenter clist=(Carpenter)currentSession().createQuery(qr)
			.setProperties(map)
			.uniqueResult();
	return clist;
	}

}
