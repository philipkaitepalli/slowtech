package org.jc.kp.service;

import java.util.List;

import org.jc.kp.dao.DayWiseBillsDao;
import org.jc.kp.model.Customer;
import org.jc.kp.model.DayWiseBills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("dayWiseBillsDao")
public class DayWiseBillsServiceImpl implements DayWiseBillsService {
	
	@Autowired
	private DayWiseBillsDao dayWiseBillsDao;

	public void create(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		dayWiseBillsDao.create(dayWiseBills);
	}


	public void update(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
		dayWiseBillsDao.delete(customer);
	}

	public DayWiseBills find(Integer pId) {
		// TODO Auto-generated method stub
		return dayWiseBillsDao.find(pId);
	}


	public List<DayWiseBills> getAll() {
		// TODO Auto-generated method stub
		return dayWiseBillsDao.getAll();
	}

	
	public Long getIdForBillGeneration() {
		// TODO Auto-generated method stub
		return dayWiseBillsDao.getIdForBillGeneration();
	}


	public List<DayWiseBills> searchByCustId(Integer x) {
		// TODO Auto-generated method stub
		return dayWiseBillsDao.searchByCustId(x);
	}

	public List<DayWiseBills> searchByDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
