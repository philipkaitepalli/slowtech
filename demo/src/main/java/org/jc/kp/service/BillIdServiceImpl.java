package org.jc.kp.service;

import org.jc.kp.dao.BillIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("billIdService")
public class BillIdServiceImpl implements  BillIdService{
	@Autowired
	private	BillIdDao billIdDao;
	
	

	public Long idGenerater() {
		 return  billIdDao.idGenerater();
				 	
			}

}
