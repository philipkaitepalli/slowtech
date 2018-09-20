package org.jc.kp.PhControllers;

import java.util.List;
import org.jc.kp.model.Customer;
import org.jc.kp.model.DayWiseBills;
import org.jc.kp.model.Voucher;
import org.jc.kp.service.DayWiseBillsService;
import org.jc.kp.service.PreBillPickerService;
import org.jc.kp.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/billsList")
public class BillsList {
	@Autowired
	private DayWiseBillsService dayWiseBillsService;
	@Autowired
	private PreBillPickerService preBillPickerService;
	@Autowired
	private VoucherService voucherService;
	Integer x=0;
	Customer customer=new Customer(); 
	Voucher voucher=new Voucher();
	Customer culist;
	 @RequestMapping(value = "/samp", method = RequestMethod.GET)
	    public ModelAndView samp(ModelAndView model) {
		model.setViewName("customerBillsList");
	        return model;
	    }
	
	 @RequestMapping(value = "/custBills", method = RequestMethod.GET)
	    public ModelAndView custBills(@RequestParam("cfn") String cfn, 
	            @RequestParam("cln") String cln) {
		 ModelAndView model=new ModelAndView();
		 customer.setCustFirstName(cfn);
		 customer.setCustLastName(cln);
		 culist=(Customer)preBillPickerService.searchCustomer(customer);
		 List<Voucher> voucher=null;
		try {
			voucher = (List<Voucher>)voucherService.getCustBill(culist);
		
		 Integer gt=0;
		 for (Voucher p : voucher) { 
		    gt=(int) (gt+p.getPtotal());
		 }
		 List<DayWiseBills> dayWiseBills=(List<DayWiseBills>)dayWiseBillsService.searchByCustId(culist.getCustomerId());
		  float amt=0,reg=0; 
		  for (DayWiseBills p : dayWiseBills) { 
			    amt=(float)(amt+p.getPaidAmount());
			 }
		  amt = (float) Math.round(amt * 100) / 100;
		 reg=gt-amt;
		 model.addObject("v",voucher);
		 model.addObject("cust",culist);
	     model.addObject("t",gt);
	     model.addObject("amount",amt);
	     model.addObject("due",reg);
		 model.setViewName("customerBillsList");
	        return model;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 model.addObject("err","enter customer first name and last name ");
			 model.setViewName("customerBillsList");
			return model;
		}
	    }
	 
	
	 @ResponseBody
	 @RequestMapping(value = "/deltVoucher")
	    public ModelAndView deltCustVoucher() {
		 ModelAndView model=new ModelAndView();
		 if(x.equals(0))
		 {
			 model.addObject("x",x);
			 x=x+1;
			 model.addObject("err","Are you sure to delete all "+culist.getCustFirstName()+"list");
			 model.setViewName("customerBillsList");
		        return model;
		 }else {
			 x=0;	
		 voucherService.deleteVoucher(culist);
		 dayWiseBillsService.delete(culist);
		 model.addObject("err","item is deleted ");
		 model.setViewName("customerBillsList");
	        return model;
		 }
			 }
}
