package org.jc.kp.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jc.kp.model.Carpenter;
import org.jc.kp.service.CarpenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/carpenter")
public class CarpenterCtrl {
	@Autowired
	private CarpenterService carpenterService;
	public CarpenterCtrl(){}
	ModelAndView model=new ModelAndView();
	 Map<String, Object> map=new HashMap<String, Object>();
	 
	 
	//-------------------------carpenterForm----------------------------------	
	 @RequestMapping(value = "/carpenterForm", method = RequestMethod.GET)
	    public ModelAndView newProducts(ModelAndView model) {
		 Carpenter carpenter = new Carpenter();
	        model.addObject("carpenter", carpenter);
	        model.setViewName("carpenterForm");
	        return model;
	    }
//-------------------------saveCarpenter----------------------------------
    @RequestMapping(value = "/saveCarpenter", method = RequestMethod.POST)
    public ModelAndView saveCarpenter(@ModelAttribute("carpenter")
    @Valid Carpenter carpenter,BindingResult result,Model model) {
    	try {
       	if (result.hasErrors()) 
    	 {
    		System.out.println("if (result.hasErrors()) ...............");
             return new ModelAndView("carpenterForm");
         }else {
    		    if (carpenter.getCarpId()==null) 
                   { // if Products id is 0 then creating the
                         // Products other updating the Products
    		    	carpenterService.create(carpenter);
        	              return new ModelAndView("redirect:/carpenter/carpenterList");
                    }else {
                    	carpenterService.update(carpenter);
                           }
                         return new ModelAndView("redirect:/carpenter/carpenterList");
               }
    	}catch(Exception e) {
    		System.out.println(e);
    	}
		return null;
      }
	
	//-------------------------editCarpenter----------------------------------	
	@RequestMapping(value = "/editCarpenter", method = RequestMethod.GET)
    public ModelAndView editCarpenter(HttpServletRequest request) {
       	int carpId =Integer.parseInt(request.getParameter("carpId")); 
       	Carpenter carpenter = carpenterService.find(carpId);
        ModelAndView model = new ModelAndView("carpenterForm");
        model.addObject("carpenter", carpenter);
        return model;
    }
	//-------------------------deleteCarpenter----------------------------------	
	
	@RequestMapping(value = "/deleteCarpenter", method = RequestMethod.GET)
    public ModelAndView deleteCarpenter(HttpServletRequest request) {
    	
    	int carpId =Integer.parseInt(request.getParameter("carpId"));
    	carpenterService.delete(carpId);
        return new ModelAndView("redirect:/carpenter/carpenterList");
    }
	//-------------------------carpenterlist----------------------------------	
	 @RequestMapping(value = "/carpenterList")
	    public ModelAndView listProducts(ModelAndView model) throws IOException {
	        List<Carpenter> listcarpenter = carpenterService.getAll();
	        model.addObject("listcarpenter", listcarpenter);
	        model.setViewName("carpenterListingPage");
	        return model;
	    }
}
