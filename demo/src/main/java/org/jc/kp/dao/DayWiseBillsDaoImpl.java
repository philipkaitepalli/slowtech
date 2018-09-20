package org.jc.kp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.Customer;
import org.jc.kp.model.DayWiseBills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DayWiseBillsDaoImpl implements DayWiseBillsDao {

	
	@Autowired
	private	SessionFactory sessionFactory;
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
		
	}
	
	/*public void create(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		
	}
	public void update(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		
	}
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	public DayWiseBills find(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<DayWiseBills> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getIdForBillGeneration() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<DayWiseBills> searchByCustId(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<DayWiseBills> searchByDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	*/
	
	

	public void create(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		currentSession().save(dayWiseBills);
		System.out.println("dayWiseBills.getId()="+dayWiseBills.getId());
		System.out.println("dayWiseBills.getBillId()="+dayWiseBills.getBillId());
		System.out.println("dayWiseBills.getBillTotal()="+dayWiseBills.getBillTotal());
		System.out.println("dayWiseBills.getCarpId()="+dayWiseBills.getCarpId());
		System.out.println("dayWiseBills.getCustomerId()="+dayWiseBills.getCustomerId());
		System.out.println("dayWiseBills.getDate()="+dayWiseBills.getDate());
		System.out.println("dayWiseBills.getPaidAmount()="+dayWiseBills.getPaidAmount());
	}

	
	public void update(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
      Integer x=customer.getCustomerId();
      currentSession().createQuery("delete DayWiseBills where customerId="+x)
      .executeUpdate();
		
	}

	
	public DayWiseBills find(Integer x) {
		return null;
		
		}

	@SuppressWarnings("unchecked")
	
	public List<DayWiseBills> getAll() {
		// TODO Auto-generated method stub
		return currentSession().createQuery("from DayWiseBills").list();
	}
	
	public Long getIdForBillGeneration() {
		// TODO Auto-generated method stub
		
		DayWiseBills blist = (DayWiseBills)currentSession().createQuery("from DayWiseBills order by Id DESC")
				.setMaxResults(1)
				.uniqueResult();
		Long s=blist.getId();
		return s;
	}
	@SuppressWarnings("unchecked")

	public List<DayWiseBills> searchByCustId(Integer x) {
		// TODO Auto-generated method stub
		return currentSession().createQuery("from DayWiseBills where customerId="+x).list();
	}
	
	public List<DayWiseBills> searchByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
