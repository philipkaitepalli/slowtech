
package org.jc.kp.controllers;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jc.kp.model.Products;
import org.jc.kp.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/dc")
public class DemoCotroller {
	@Autowired
	private ProductsService productsService;
	/*@Autowired
	private CalsService calsService;
	@Autowired
	private CalService calService;*/
	ModelAndView model=new ModelAndView();
	 Map<String, Object> map=new HashMap<String, Object>();
	public DemoCotroller() {}
	 
	
	
	@RequestMapping(value = "/dcb", method = RequestMethod.GET)
	  public ModelAndView billingById() {
  	ModelAndView model =new ModelAndView();
  	model.setViewName("ajaxById");
	    return model;  
	  }

	@RequestMapping(value = "/dc", method = RequestMethod.GET)
	  public ModelAndView home() {
  	ModelAndView model =new ModelAndView();
  	model.setViewName("home");
	    return model;  
	  }
//============================================Time===================================	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	  public @ResponseBody String getTime(@RequestParam String name) {
	    String result = "Time for " + name + " is " + new Date().toString();
	    return result;
	  }
	
	
	//======================================ajaxById===========================================	
		
	/*
	@RequestMapping(value = "/getAjaxById", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
   public Map<String, Object>  ajaxById(HttpServletRequest req,HttpServletResponse res)throws Exception {
		
		
		
		 
			try {
				
				Integer pId=Integer.parseInt(req.getParameter("pId"));
				Integer fd=Integer.parseInt(req.getParameter("fd"));
	           	Integer sd=Integer.parseInt(req.getParameter("sd"));
	           	Integer nop=Integer.parseInt(req.getParameter("nop"));
	           	System.out.println("------------------------");
				if(pId!=0&&fd!=0&&sd!=0) {
	           	System.out.println("from controll------->"+pId+"--"+fd+"-- "+sd+"----"+nop);
	           	calService.setFd(fd);
	           	calService.setSd(sd);
	           	calService.setNop(nop);
	          
	           	Products products=productsService.find(pId);
		    	 calService=calsService.mult(products,calService);
		    	 
		    	 map.put("cs",calService);
		    	 map.put("pds",products);
		    	
		    	
				}
				System.out.println("......"+map);
		        return map;
				
			} catch (Exception e) {
				map.put("error", "Please Enter valid data....");
				System.out.println("++++++ppp++++++");
				
				
		    
				return map;
			}
		 }
		 

	*/
//===============================/BySdAndName=========================================================================	
	/*
	@RequestMapping(value = "/BySdAndName", method = RequestMethod.GET)
    public ModelAndView BySdAndName(HttpServletRequest req,ModelAndView model) {
		
		
		 try {   
				String pStandurdDimension=(req.getParameter("pStandurdDimension"));
	           	String pName=(req.getParameter("pName"));
	           	Integer fd=Integer.parseInt(req.getParameter("fd"));
	           	Integer sd=Integer.parseInt(req.getParameter("sd"));
	           	Integer nop=Integer.parseInt(req.getParameter("nop"));
		    	
	           	calService.setFd(fd);
	           	calService.setSd(sd);
	           	calService.setNop(nop);
		    	
		    	System.out.println("from controll------->"+pStandurdDimension+" "+pName+" "+fd+" "+sd+" "+nop);
		    	
		   Products products=productsService.find(pStandurdDimension,pName);
		     calService=calsService.mult(products,calService);
		    	
		    	model.addObject(products);
    	    	model.addObject("calService",calService);
          
		 }catch(Exception e){
			 System.out.println(e.toString());
			 
			  String err="Fillup  all entries by proper values ....";
     	      model.addObject("err",err);
			  model.setViewName("BySdAndName");
			  System.out.println(" this is from catch block ...........");
		        return model;
			 
		        }     
		 
		    	model.setViewName("BySdAndName");
	            return model;
    }*/
	


//-----------------------------------Products Registration----------------------------------------------------	
    @RequestMapping(value = "/plist")
    public ModelAndView listProducts(ModelAndView model) throws IOException {
        List<Products> listproducts = productsService.getAll();
        model.addObject("listproducts", listproducts);
        model.setViewName("productsListingPage");
        return model;
    }
 
    @RequestMapping(value = "/productsForm", method = RequestMethod.GET)
    public ModelAndView newProducts(ModelAndView model) {
    	Products products = new Products();
        model.addObject("products", products);
        model.setViewName("productsForm");
        return model;
    }
 
    @RequestMapping(value = "/saveProducts", method = RequestMethod.POST)
    public ModelAndView saveProducts(@ModelAttribute("products")
                                     @Valid Products products,
                                     BindingResult result,Model model) {
       	if (result.hasErrors()) 
    	 {
    		System.out.println("if (result.hasErrors()) ...............");
             return new ModelAndView("productsForm");
         }else {
    		    if (products.getpId() == 0) 
                   { // if Products id is 0 then creating the
                         // Products other updating the Products
           	              productsService.create(products);
        	              return new ModelAndView("redirect:/dc/plist");
                    }else {
        	               productsService.update(products);
                           }
                         return new ModelAndView("redirect:/dc/plist");
               }
      }
  
    @RequestMapping(value = "/deleteProducts", method = RequestMethod.GET)
    public ModelAndView deleteProducts(HttpServletRequest request) {
    	
    	int pId =Integer.parseInt(request.getParameter("pId"));
        productsService.delete(pId);
        return new ModelAndView("redirect:/dc/plist");
    }
 
    @RequestMapping(value = "/editProducts", method = RequestMethod.GET)
    public ModelAndView editProducts(HttpServletRequest request) {
       	int pId =Integer.parseInt(request.getParameter("pId")); 
        Products products = productsService.find(pId);
        ModelAndView model = new ModelAndView("productsForm");
        model.addObject("products", products);
        return model;
    }
    
   
	
}