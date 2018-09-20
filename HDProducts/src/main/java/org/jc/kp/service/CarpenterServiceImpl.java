package org.jc.kp.service;

import java.util.List;

import org.jc.kp.dao.CarpenterDao;
import org.jc.kp.model.Carpenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("carpenterService")
public class CarpenterServiceImpl implements CarpenterService {
	@Autowired
    private	CarpenterDao carpenterDao;
	
	@Override
	public void create(Carpenter carpenter) {
		carpenterDao.create(carpenter);
	}

	@Override
	public void update(Carpenter carpenter) {
		carpenterDao.update(carpenter);
		
	}

	@Override
	public void delete(Integer carpId) {
		carpenterDao.delete(carpId);
	}

	@Override
	public Carpenter find(Integer carpId) {
		return carpenterDao.find(carpId);
	}

	@Override
	public List<Carpenter> getAll() {
		return carpenterDao.getAll();
	}

}
