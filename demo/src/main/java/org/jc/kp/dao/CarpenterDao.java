package org.jc.kp.dao;

import java.util.List;

import org.jc.kp.model.Carpenter;

public interface CarpenterDao {

	    public void create(Carpenter carpenter);
	    public void update(Carpenter carpenter);
		public void delete(Integer pId);
		public Carpenter find(Integer pId);
		public List<Carpenter> getAll();
}
