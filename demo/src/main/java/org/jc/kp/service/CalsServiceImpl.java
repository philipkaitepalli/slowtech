package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.CalService;
import org.jc.kp.model.Products;
import org.springframework.stereotype.Service;
@Service("CalsService")
public class CalsServiceImpl implements CalsService {
	Products products;
	
	public CalService add(CalService calService) {
		
		
		return calService;
	}
	
	public CalService mult(Products products,CalService calService) {
		// TODO Auto-generated method stub
		Float tt=(Float)products.getpUnitPrice()*calService.getFd()*calService.getSd()*calService.getNop();
		calService.setTotal(tt);
		return calService;
	}
	
	
	
	public CalService mult(List<Products> list, CalService calService) {
		float p=0;
		if(calService.getPercent()==null)
		{
			calService.setPercent(p);
		for(int i=0;i<list.size();i++) {
			Float ttt=(Float)list.get(i).getpUnitPrice()*calService.getFd()*calService.getSd()*calService.getNop();
			Float tt=ttt+(ttt*calService.getPercent()/100);
			System.out.println("......if.........>"+tt);
		calService.setTotal(tt);
			 }
		}else {
			for(int i=0;i<list.size();i++) {
				Float ttt=(Float)list.get(i).getpUnitPrice()*calService.getFd()*calService.getSd()*calService.getNop();
				Float tt=ttt+(ttt*calService.getPercent()/100);
				System.out.println("----------else------>"+tt);
			calService.setTotal(tt);
		}
		}
		return calService;
	}
	public CalService sub(Float pp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CalService dive(Float pp) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
