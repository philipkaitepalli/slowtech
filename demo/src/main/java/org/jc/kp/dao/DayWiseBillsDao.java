package org.jc.kp.dao;

import java.util.List;

import org.jc.kp.model.Customer;
import org.jc.kp.model.DayWiseBills;

public interface DayWiseBillsDao {
	public void create(DayWiseBills dayWiseBills);
    public void update(DayWiseBills dayWiseBills);
	public void delete(Customer customer);
	public DayWiseBills find(Integer pId);
	public List<DayWiseBills> getAll();
	public Long getIdForBillGeneration();
	
	//public List<DayWiseBills> searchByCustId();
//	public List<DayWiseBills> searchByDate();
	
	
	public List<DayWiseBills> searchByCustId(Integer pId);
	public List<DayWiseBills> searchByDate();
	
}
