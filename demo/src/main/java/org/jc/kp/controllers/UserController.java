package org.jc.kp.controllers;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jc.kp.dao.UserDao;
import org.jc.kp.exceptions.UserBlockedException;
import org.jc.kp.model.User;
import org.jc.kp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	public UserService userService;
	
	
	@RequestMapping(value = "/dc", method = RequestMethod.GET)
	  public ModelAndView home() {
	ModelAndView model =new ModelAndView();
	model.setViewName("home");
	    return model;  
	  }
	
	@RequestMapping(value = "/loginForm",method = RequestMethod.GET )
    public ModelAndView loginForm(ModelAndView model) {
      User user=new User();
      model.addObject("user", user);
    model.setViewName("loginPage");
    return model;
}
	@RequestMapping(value = "/userLogin",method = RequestMethod.POST )
    public String userLogin(@ModelAttribute("user") User user,
           Model model,HttpSession session) {
		User loggedinUser;
		
		System.out.println("?????????____1");
		try {
			
			loggedinUser = userService.login(user);
			System.out.println("==="+loggedinUser.getRoll());
			//User loggedinUser = userService.login(user);
			//login is success
			if(loggedinUser.getRoll().equals(UserDao.ADMIN)) {
				//if login user is admin
				System.out.println("?????????____Admin");
				addUserSession(loggedinUser,session);
				return "redirect:adminDashBd";
				
			}else if(loggedinUser.getRoll().equals(UserDao.USER)){
				//if login user is user
				System.out.println("?????????____user");
				addUserSession(loggedinUser,session);
				return "redirect:userDashBd";
			}else {
				//if login user is guest
				 return null;
			}
			
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			System.out.println("??????????_____2");
			model.addAttribute("err",e.getMessage());
			return null;

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "redirect:loginForm?act=nul";

		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return null;

		}
		
} 
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET )
    public String logout( HttpSession session) {
    		session.invalidate();
    		
    return "redirect:loginForm?act=lo";
    }
	 
	   
	   @RequestMapping(value = "/adminDashBd",method = RequestMethod.GET )
	    public ModelAndView adminDashBd(ModelAndView model) {
	     
	    model.setViewName("adminDashBd");
	    return model;
	   }
	   @RequestMapping(value = "/userDashBd",method = RequestMethod.GET )
	    public ModelAndView userDashBd(ModelAndView model) {
	      
	    model.setViewName("userDashBd");
	    return model;
	   }
	   
	  
	    private void addUserSession(User u,HttpSession session) {
	    	session.setAttribute("user",u);
	    	session.setAttribute("userId",u.getUserId());
	    	session.setAttribute("userRoll",u.getRoll());
	   }
	    
	    
	    @RequestMapping(value = "/loginRegForm",method = RequestMethod.GET )
	    public ModelAndView loginRegForm(ModelAndView model) {
	      User user=new User();
	      model.addObject("user", user);
	    model.setViewName("loginRegForm");
	    return model;
	}
	    @RequestMapping(value = "/userRegForm", method = RequestMethod.POST)
        public String userRegistration(@ModelAttribute("user")
        @Valid User user,
        BindingResult result,Model model) {
	    	if (result.hasErrors()) 
	    	 {
	    		System.out.println("if (result.hasErrors()) ...............");
	    		return "loginRegForm";
	         }else {
	    	    	try {
							user.setLoginStatus(1);
                            user.setRoll(2);
							userService.Registration(user);
							return "redirect:loginForm?act=reg";
						} catch (PersistenceException e) {
							// TODO Auto-generated catch block
							
							System.out.println("ppppp******");
							e.printStackTrace();
							model.addAttribute("err","LoginName already existed please select another name");
							 return "loginRegForm";
						}catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("ppppp=====");
							e.printStackTrace();
							 return "redirect:loginForm";
						}
	
	         }
    }
}
