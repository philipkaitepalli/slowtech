package org.jc.kp.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.Customer;
import org.jc.kp.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class VoucherDaoImpl implements VoucherDao {
	
	@Autowired
	private	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public String createVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		if(voucher.getpStandurdDimension()==null||voucher.getpName()==null||voucher.getFd()==null||voucher.getNop()==null) {
			return "Product is not added to bill please again";
		}else {
		currentSession().save(voucher);
		return "Product is added to bill successfully...";
	}
		}

	@Override
	public void updateVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		currentSession().update(voucher);
		
	}

	@Override
	public void deleteVoucher(Integer  pbId) {
		System.out.println("pbid="+pbId);
		Voucher voucher = (Voucher) currentSession().load(Voucher.class,pbId);
		currentSession().delete(voucher);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voucher> findVoucher(Integer pbId) {
		// TODO Auto-generated method stub
		return (List<Voucher>)currentSession().get(Voucher.class,pbId);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voucher> getAll(Long billId) {
		// TODO Auto-generated method stub
		//Long x=voucher.getBillId() ;
		return (List<Voucher>)currentSession().createQuery("select p from Voucher p where p.billId="+billId).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Voucher> getAll() {
		// TODO Auto-generated method stub
		
		//return (List<Voucher>)currentSession().createQuery("select p from Voucher p where p.billId="+x).list();
		return (List<Voucher>)currentSession().createQuery("from Voucher").list();
	}


	
	@Override
	public void deleteVoucher(Customer customer) {
		// TODO Auto-generated method stub
		Integer x=customer.getCustomerId();
		
		currentSession().createQuery("delete Voucher where custId="+x)
		
		.executeUpdate();
		
		 /* String deleteQuery = "delete from students where joinDate= :joinDate";
	      Query query = session.createQuery(deleteQuery);
	      query.setString("joinDate", "2014-03-08"); //convert date from string
	      query.executeUpdate()*/
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Voucher> getCustBill(Customer customer) {
		// TODO Auto-generated method stub
		return (List<Voucher>)currentSession().createQuery("select p from Voucher p where p.custId="+customer.getCustomerId()).list();
	}


	@Override
	public Voucher find(Integer bpId) {
		return (Voucher)currentSession().get(Voucher.class,bpId);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Voucher> findDynamiVoucher(Long billId) {
		// TODO Auto-generated method stub
		return (List<Voucher>)currentSession().createQuery("select p from Voucher p where p.billId="+billId).list();
	}



	
}
