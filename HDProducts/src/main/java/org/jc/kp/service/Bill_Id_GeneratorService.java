package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.Bill_Id_Generator;

public interface Bill_Id_GeneratorService {
	
	public void create(Bill_Id_Generator bill_Id_Generator);
    public void update(Bill_Id_Generator bill_Id_Generator);
	public void delete(Integer pId);
	public Bill_Id_Generator find(Integer pId);
	public List<Bill_Id_Generator> getAll();
	
}
