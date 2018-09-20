package org.jc.kp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/cus")
public class TestControll {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	  public ModelAndView billingById() {
	ModelAndView model =new ModelAndView();
	model.setViewName("ajaxById");
	    return model;  
	  }

}
