package org.jc.kp.PhControllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jc.kp.model.Customer;
import org.jc.kp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/customer")
public class CustomerCtrl {

	@Autowired
	private CustomerService customerService;
	public CustomerCtrl(){}
	ModelAndView model=new ModelAndView();
	 Map<String, Object> map=new HashMap<String, Object>();
	 
	//-------------------------CustomerForm----------------------------------	
		 @RequestMapping(value = "/customerForm", method = RequestMethod.GET)
		    public ModelAndView newCustomer(ModelAndView model) {
			 Customer customer = new Customer();
		        model.addObject("customer", customer);
		        model.setViewName("customerForm");
		        return model;
		    }
	//-------------------------saveCustomer----------------------------------
	    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	    public ModelAndView saveCustomer(@ModelAttribute("customer")
        @Valid Customer customer,
        BindingResult result,Model model) {
	    	if (result.hasErrors()) 
	    	 {
	    		return new ModelAndView("customerForm");
	    		//return "redirect:/customer/customerForm";
	         }else {
	    	    
	    		    if (customer.getCustomerId()==null) 
	                   { // if Products id is 0 then creating the
	                         // Products other updating the Products
	    		    	customerService.create(customer);
	        	            //  return "redirect:/customer/customerList";
	    		    	 return new ModelAndView("redirect:/customer/customerList");
	                    }else {
	                    	customerService.update(customer);
	                           }
	                         //return"redirect:/customer/customerList";
	    		    return new ModelAndView("redirect:/customer/customerList");
	               }        
	      }
		//-------------------------editCustomer----------------------------------	
		@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	    public ModelAndView editCustomer(HttpServletRequest request) {
	       	int customerId =Integer.parseInt(request.getParameter("customerId")); 
	       	Customer customer = customerService.find(customerId);
	        ModelAndView model = new ModelAndView("customerForm");
	        model.addObject("customer", customer);
	        return model;
	    }
		//-------------------------deleteCustomer----------------------------------	
		
		@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	    public ModelAndView deleteCustomer(HttpServletRequest request) {
	    	
	    	int customerId =Integer.parseInt(request.getParameter("customerId"));
	    	customerService.delete(customerId);
	        return new ModelAndView("redirect:/customer/customerList");
	    }
		//-------------------------Customerlist----------------------------------	
		 @RequestMapping(value = "/customerList")
		    public ModelAndView listCustomer(ModelAndView model) throws IOException {
		        List<Customer> listcustomer = customerService.getAll();
		        model.addObject("listcustomer", listcustomer);
		        model.setViewName("customerList");
		        return model;
		    }
	}

