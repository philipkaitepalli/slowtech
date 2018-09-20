package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.Customer;
import org.jc.kp.model.DayWiseBills;

public interface DayWiseBillsService {
	public void create(DayWiseBills dayWiseBills);
    public void update(DayWiseBills dayWiseBills);
	public void delete(Customer customer);
	public DayWiseBills find(Integer pId);
	public List<DayWiseBills> getAll();
	public Long getIdForBillGeneration();
	
	public List<DayWiseBills> searchByCustId(Integer x);
	public List<DayWiseBills> searchByDate();
}
