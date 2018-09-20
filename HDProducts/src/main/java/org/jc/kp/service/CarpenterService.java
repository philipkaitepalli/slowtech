package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.Carpenter;

public interface CarpenterService {
	public void create(Carpenter carpenter);
    public void update(Carpenter carpenter);
	public void delete(Integer pId);
	public Carpenter find(Integer pId);
	public List<Carpenter> getAll();
}
