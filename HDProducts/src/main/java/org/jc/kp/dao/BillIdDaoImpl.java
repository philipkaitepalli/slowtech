package org.jc.kp.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.Bill_Id_Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("deprecation")
@Repository
@Transactional
public class BillIdDaoImpl implements BillIdDao{
	@Autowired
	private	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long idGenerater() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Query<Object> query=(Query<Object>)currentSession().createQuery("from Bill_Id_Generator order by Id DESC")
		  .setMaxResults(1);
		Bill_Id_Generator blist = (Bill_Id_Generator) query.uniqueResult();
		Long s=blist.getId();
		System.out.println("...blist....>>>"+s);
				return s;
	}
	
}
