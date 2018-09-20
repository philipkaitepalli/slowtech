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
	@Override
	public void create(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		dayWiseBillsDao.create(dayWiseBills);
	}

	@Override
	public void update(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
		dayWiseBillsDao.delete(customer);
	}

	@Override
	public DayWiseBills find(Integer pId) {
		// TODO Auto-generated method stub
		return dayWiseBillsDao.find(pId);
	}

	@Override
	public List<DayWiseBills> getAll() {
		// TODO Auto-generated method stub
		return dayWiseBillsDao.getAll();
	}

	@Override
	public Long getIdForBillGeneration() {
		// TODO Auto-generated method stub
		return dayWiseBillsDao.getIdForBillGeneration();
	}

	@Override
	public List<DayWiseBills> searchByCustId(Integer x) {
		// TODO Auto-generated method stub
		return dayWiseBillsDao.searchByCustId(x);
	}

	@Override
	public List<DayWiseBills> search(DayWiseBills dayWiseBills) {
		// TODO Auto-generated method stub
		System.out.println(".....service.....");
		return dayWiseBillsDao.search(dayWiseBills);
	}

}
