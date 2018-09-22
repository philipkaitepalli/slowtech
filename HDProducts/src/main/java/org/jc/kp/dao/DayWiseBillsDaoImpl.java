package org.jc.kp.dao;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	@Override
	public void create(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		
		try {
			currentSession().save(dayWiseBills);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DayWiseBills error="+e); 
		}
		
	}

	@Override
	public void update(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
      try {
		Integer x=customer.getCustomerId();
		  currentSession().createQuery("delete DayWiseBills where customerId="+x)
		  .executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
		
	}

	@Override
	public DayWiseBills find(Integer x) {
		return null;
		
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<DayWiseBills> getAll() {
		// TODO Auto-generated method stub
		return currentSession().createQuery("from DayWiseBills").list();
	}
	@Override
	public Long getIdForBillGeneration() {
		// TODO Auto-generated method stub
		
		DayWiseBills blist = (DayWiseBills)currentSession().createQuery("from DayWiseBills order by Id DESC")
				.setMaxResults(1)
				.uniqueResult();
		Long s=blist.getId();
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DayWiseBills> searchByCustId(Integer x) {
		// TODO Auto-generated method stub
		return currentSession().createQuery("from DayWiseBills where customerId="+x).list();
	}
	
	@Override
	public List<DayWiseBills> search(DayWiseBills dayWiseBills) {
		String dt=dayWiseBills.getDate();
		
		/*SimpleDateFormat dateFormatter = new SimpleDateFormat("d/MM/yyyy");
		Date beginDate=null;
		try {
			beginDate =  dateFormatter.parse(date);
			System.out.println("beginDate=="+beginDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String sql="FROM DayWiseBills WHERE date=:dt";
	 @SuppressWarnings("unchecked")
	List<DayWiseBills> dwb=(List<DayWiseBills>)currentSession()
	.createQuery(sql)
	.setParameter("dt", dt)
	.list();
	 
		return dwb;
		 	}
	
}
