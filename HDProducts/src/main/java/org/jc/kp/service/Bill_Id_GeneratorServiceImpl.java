package org.jc.kp.service;

import java.util.List;

import org.jc.kp.dao.Bill_Id_GeneratorDao;
import org.jc.kp.model.Bill_Id_Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("bill_Id_GeneratorService")
public class Bill_Id_GeneratorServiceImpl implements Bill_Id_GeneratorService {

	
	@Autowired
    private Bill_Id_GeneratorDao bill_Id_GeneratorDao;
	@Override
	public void create(Bill_Id_Generator bill_Id_Generator) {
		// TODO Auto-generated method stub
		bill_Id_GeneratorDao.create(bill_Id_Generator);
	}

	@Override
	public void update(Bill_Id_Generator bill_Id_Generator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer pId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bill_Id_Generator find(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill_Id_Generator> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
