package org.jc.kp.PhControllers;

import java.text.ParseException;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jc.kp.model.Bill_Id_Generator;
import org.jc.kp.model.CalService;
import org.jc.kp.model.Carpenter;
import org.jc.kp.model.Customer;
import org.jc.kp.model.DayWiseBills;
import org.jc.kp.model.Products;
import org.jc.kp.model.Voucher;
import org.jc.kp.service.BillingService;
import org.jc.kp.service.CalsService;
import org.jc.kp.service.DayWiseBillsService;
import org.jc.kp.service.PreBillPickerService;
import org.jc.kp.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/pbpc")
public class PreBillPickerController {
	@Autowired
	private DayWiseBillsService dayWiseBillsService;
	/*@Autowired
	private Bill_Id_GeneratorService bill_Id_GeneratorService;*/
	@Autowired
	private PreBillPickerService preBillPickerService;
	@Autowired
	private BillingService billingService;
	@Autowired
	private CalsService calsService;
	/*@Autowired
	private BillIdService billIdService;*/
	@Autowired
	private VoucherService voucherService;
	
	Float gtotal=(float) 0,total=(float) 0;
	Long billId=(long)0;
	Integer custId;
	Integer carpId;
	Date date;
	Customer culist;
	Carpenter calist;
	Date dt;
	
	 DayWiseBills dayWiseBills=new DayWiseBills();
	 Customer customer=new Customer();
	 Carpenter carpenter=new Carpenter();
	 Bill_Id_Generator bill_Id_Generator=new Bill_Id_Generator();
	 Voucher voucher=new Voucher();
	 PreBillPickerController(){}
	 ModelAndView model=new ModelAndView();
	 Map<String, Object> map=new HashMap<String, Object>();
	 
	
	@RequestMapping(value = "/preBillPicker", method = RequestMethod.GET)
	  public ModelAndView preBillPicker() {
	  model.setViewName("preBillPicker");
	    return model;  
	}
//=========================================================================================================	 
	 @RequestMapping(value = "/custFirstName")
	 @ResponseBody
	    public String getCustomerFirstName(HttpServletRequest req) {
		String ss=req.getParameter("term");
		System.out.println(ss);
	    Gson gson=new Gson();
		String rs=gson.toJson(preBillPickerService.searchCustomerFirstName(ss));
		return rs;	
	}
	 
	 @RequestMapping(value = "/custLastName")
	 @ResponseBody
	    public String getCustomerLastName(HttpServletRequest req) {
		String ss=req.getParameter("term");
	    Gson gson=new Gson();
		String rs=gson.toJson(preBillPickerService.searchCustomerLastName(ss));
		return rs;	
	}
//==============================================================================================================	 
	 
	 @RequestMapping(value = "/carpFirstName")
	 @ResponseBody
	    public String getCarpFirstName(HttpServletRequest req) {
		String ss=req.getParameter("term");
	    Gson gson=new Gson();
		String rs=gson.toJson(preBillPickerService.searchCarpenterFirstName(ss));
		return rs;	
	}
	 @RequestMapping(value = "/carpLastName")
	 @ResponseBody
	    public String getCarpLastName(HttpServletRequest req) {
		String ss=req.getParameter("term");
	    Gson gson=new Gson();
		String rs=gson.toJson(preBillPickerService.searchCarpenterLastName(ss));
		return rs;	
	}
//-----------------------------------------------------------------------------------	 
	 @RequestMapping(value = "/fristProperty")
	 @ResponseBody
	    public String getFristProperty(HttpServletRequest req) {
		String fp=req.getParameter("term");
	    Gson gson=new Gson();
		String rs=gson.toJson(billingService.searchFp(fp));
		return rs;
		 }
	@RequestMapping(value = "/secondProperty")
	 @ResponseBody
	    public String getSecondProperty(HttpServletRequest req) {
		String sp=req.getParameter("term");
	    Gson gson=new Gson();
		String rs=gson.toJson(billingService.searchSp(sp));
		return rs; 	
	}
	
//==================================================================================	
	
	
	
	
	 @RequestMapping(value = "/getIds")
	    public ModelAndView getIds(HttpServletRequest req) {
		 try {
			String cfn=req.getParameter("cfn");
			 String cln=req.getParameter("cln");
			 String cafn=req.getParameter("cafn");
			 String caln=req.getParameter("caln");
			if(cfn.isEmpty()||cln.isEmpty()||cafn.isEmpty()||caln.isEmpty()) {
				 model.addObject("err","Fillup all entries by proper values....");
				 model.setViewName("preBillPicker");
				return model;
			}else {
			 customer.setCustFirstName(cfn);
			 customer.setCustLastName(cln);
			 carpenter.setCarpFirstName(cafn);
			 carpenter.setCarpLastName(caln);
			
			 model=idsPicker( customer, carpenter);
			 model.setViewName("preBillProductSearch");
			    
		     return model;
			 
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return model;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return model;
		}
		
		 	 
	}
	 
	 /**
	  * this method generates customer Id,carpenter Id and bill Id
	  * and returns model object
	  * 
	  * 
	  * @param customer
	  * @param carpenter
	  * @return
	  */
	 public ModelAndView idsPicker(Customer customer,Carpenter carpenter) {
		
		
		culist=(Customer)preBillPickerService.searchCustomer(customer);
		calist=(Carpenter) preBillPickerService.searchCarpenter(carpenter);
		 
		 billId=dayWiseBillsService.getIdForBillGeneration();
		 model.addObject("bId",billId);
		 model.addObject("cul",culist.getCustomerId());
		 model.addObject("cufn",culist.getCustFirstName());
		 model.addObject("culn",culist.getCustLastName());
		 model.addObject("cal",calist.getCarpId());
		 return model;
			 }
		
	 @RequestMapping(value = "/getBill")
	 @ResponseBody
	    public Map<String, Object> getBill(@ModelAttribute("calService") CalService calService) {
					if(calService.getFp()==""||calService.getSp()==""||calService.getFd()==null  || calService.getNop()==null) {
				if(calService.getFp()=="") {
					map.put("err","* Select 'first property' proper value");		
					 return map;
				}else if(calService.getSp()==""){
					map.put("err","* Select 'second property' proper value");		
					 return map;
				}else if(calService.getFd()==null) {
					 map.put("err","**  Enter 'first dimention'with proper values");
					 return map;
				}
				 map.put("err","** Enter all properties proper values");		
				 return map;
			}else {
				
			Products list=billingService.searchProducts(calService);
			if(list!=null) {
				/**
				 * if second dimension is not need to a property
				 * 
				 * Nop also need not to a property
				 * 
				 * here they set to '1'
				 * 
				 */
			
				if(calService.getNop()==null) {
					calService.setNop(1);
				}
				if(calService.getSd()==null) {
					calService.setSd(1);
				}
		try { 
			calsService.mult(list, calService);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			 
			voucher.setpName(list.getpName());
			voucher.setpStandurdDimension(list.getpStandurdDimension());
			voucher.setpUnitType(list.getpUnitType());
			voucher.setpUnitPrice(list.getpUnitPrice());
			 custId=culist.getCustomerId();
			 carpId=calist.getCarpId();
			 voucher.setBillDate(calService.getDt());
			 voucher.setCustId(custId);
			 voucher.setCarpId(carpId);
			 voucher.setBillId(billId);
			 voucher.setFd(calService.getFd());
			 voucher.setSd(calService.getSd());
			 voucher.setNop(calService.getNop());
			 voucher.setPtotal(calService.getTotal());
			 String ss=voucherService.createVoucher(voucher);
			 map.put("err",ss);
			 return map;
		}
			else{
				map.put("err","You can't find this product in Products_list please check once");
				 return map;	
			}
			}
		}
	 /**
	  * this method edit the voucher
	  * @param voucher
	  * @return
	  */
	 
	 @RequestMapping(value = "/editProduct")
	   public  ModelAndView edit(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		int pbId =Integer.parseInt(request.getParameter("id")); 	
		Voucher voucher = voucherService.find(pbId);
         model.addObject("voucher", voucher);
		/* map.put("err","item is edited ");*/
        model.setViewName("vocherForm");
        return model;		
			 }
	 
	 @RequestMapping(value = "/saveVoucher")
	 public ModelAndView saveVoucher(@ModelAttribute("voucher")
     @Valid Voucher voucher,
     BindingResult result) {
		 saveOrEdit(voucher);
		 map.put("err","item is edited ");
   model.setViewName("preBillProductSearch");
return model;
}	 
	 /**
	  * this method saves or edit the Voucher object
	  * @param voucher
	  * @return @ResponseBody
	  */
 
 public void saveOrEdit(Voucher voucher) {
	 System.out.println("customer.getCustomerId()="+culist.getCustomerId());
		    voucherService.updateVoucher(voucher);
 }
  
	 @RequestMapping(value = "/list")
	 @ResponseBody
	    public Map<String, Object> list() {
		 gtotal=(float) 0;total=(float) 0;
	    List<Voucher> li=(List<Voucher>)voucherService.getAll(billId);
	    
	   for(int i=0;i<li.size();i++) {
	    	total=li.get(i).getPtotal();
	    	 gtotal=gtotal+total;
	    }
	    System.out.println("gtotal=="+gtotal);
		map.put("cs",li);
		map.put("gs",gtotal);
		 return map;
		 }
	 
	 @RequestMapping(value = "/vocherlist")
		 public ModelAndView vocherlist() {
		 List<Voucher> li=(List<Voucher>)voucherService.getAll();
	    model.addObject("li",li);
	    model.setViewName("vocherlist");
		 return model;
		 }

	 @RequestMapping(value = "/dwbl")
	 @ResponseBody
		 public ModelAndView dayWiseBillsList() {
		 ModelAndView m=new ModelAndView();
		 List<DayWiseBills> li=(List<DayWiseBills>)dayWiseBillsService.getAll();
	   m.addObject("li",li);
	   m.setViewName("DayWiseBillslist");
	    return m;
	 } 
//=====================================Day wise bills search============================================	 
	
	 @RequestMapping(value = "/dateWise")
	 @ResponseBody
	  public ModelAndView dayWiseBill(@RequestParam("dp") String dts){
		 ModelAndView m=new ModelAndView();
		 System.out.println("========Strings======"+dts);
		dayWiseBills.setDate(dts);
		List<DayWiseBills> lis=(List<DayWiseBills>)dayWiseBillsService.search(dayWiseBills);
		try {
			if(lis.isEmpty()) {
				 System.out.println("--if---****"+lis.toString());
				m.addObject("err", "Sorry you cannot find bills on this given date");
				m.addObject("li", lis);
				System.out.println("hello pppp  empty....");
			    return m; 
			}else {
			 System.out.println("-----****"+lis.toString());
			 m.addObject("li", lis);
			  System.out.println("hello pppp");
			return m;  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hi>>>>>>>>>>>>>>>>>>>>>");
			e.printStackTrace();
			return null;
		}
	}
	 
		 @RequestMapping(value = "/deleteProduct")
	     @ResponseBody
	    public Map<String, Object> deleteProduct(@ModelAttribute("voucher") Voucher voucher) {
		 voucherService.deleteVoucher(voucher.getPbId());
		 map.put("err","item is deleted ...");
		 return map;
			
			 }
	 
    /*============================bill_Id_GeneratorService=================================*/	 
	 
	 
	 @RequestMapping(value = "/bill_Id_GeneratorSave")
	 @ResponseBody
	    public Map<String, Object> bill_Id_Gen(@RequestParam("objs") Float objs, 
	          @RequestParam("dts") String dts) throws ParseException {
		 dayWiseBills.setBillId(billId);
		 dayWiseBills.setBillTotal(gtotal);
		 dayWiseBills.setCarpId(carpId);
		 dayWiseBills.setCustomerId(custId);
		 dayWiseBills.setDate(dts);
		 dayWiseBills.setPaidAmount(objs);
		 dayWiseBillsService.create(dayWiseBills);
		 return map;
		 }
	 
	 @RequestMapping(value = "/dynaBill", method = RequestMethod.GET)
	  public ModelAndView dynaBill() {
		model.addObject(voucher);
	     model.setViewName("DynamiVoucher");
	    return model;  
	}
	 @RequestMapping(value = "/dynaBills", method = RequestMethod.GET)
	 public ModelAndView dynaBills(HttpServletRequest request) {
		   float gtotal=0,p;
			Long bId =Long.parseLong(request.getParameter("pId")); 
		 List <Voucher> billList=voucherService.findDynamiVoucher(bId);
		 //model=idsPicker( customer, carpenter);
		 for(Voucher v:billList) {
			 p=v.getPtotal();
			 gtotal=gtotal+p;
		 }
		
		 if (billList.isEmpty()) {
			model.addObject("err", "search is fail....You can not find bill on this number.");
			model.addObject("billList",billList);
			model.setViewName("DynamiVoucher");
			return model;
		}else {
			model.addObject("err", "search is Succefull.....");
			model.addObject("billList",billList);
			model.addObject("gtotal",gtotal);
			model.setViewName("DynamiVoucher");
			return model;
		}
	}
}

