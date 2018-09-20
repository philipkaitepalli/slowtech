
package org.jc.kp.PhControllers;
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
	
	ModelAndView model=new ModelAndView();
	 Map<String, Object> map=new HashMap<String, Object>();
	public DemoCotroller() {}

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
	
//-----------------------------------Products Registration----------------------------------------------------	
    @RequestMapping(value = "/plist")
    public ModelAndView listProducts(ModelAndView model) throws IOException {
        List<Products> listproducts = productsService.getAll();
        model.addObject("listproducts", listproducts);
        model.setViewName("productsListingPage");
        return model;
    }
    
    @RequestMapping(value = "/free_search")
    public ModelAndView free_search(@RequestParam("freeText") String freeText ) throws IOException {
    	
    	ModelAndView m=new ModelAndView();
    	List<Products> listproducts =productsService.search(freeText);
    	
    	System.out.println(" listproducts listproducts  "+listproducts);
    	if(listproducts.isEmpty()) {
    		  m.addObject("err","you can not search anything by this text...");
    	       m.setViewName("productsListingPage");
    	        return m;
    	}else {
    		 m.addObject("listproducts", listproducts);
    	       m.setViewName("productsListingPage");
    	        return m;
    	}
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