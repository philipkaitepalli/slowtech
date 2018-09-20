package org.jc.kp.PhControllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/loginRegList", method = RequestMethod.GET)
	  public ModelAndView loginRegList() {
	ModelAndView model =new ModelAndView();
	List<User>ul=userService.getAll();
	System.out.println("userService.getAll()"+ul.toString());
	
	model.addObject("ul",ul);
	model.setViewName("usersList");
	    return model;  
	  }
//==========================loginForms==============================================	
	@RequestMapping(value = "/loginForm",method = RequestMethod.GET )
    public ModelAndView loginForm(ModelAndView model) {
		 User user=new User();
      model.addObject("user", user);
    model.setViewName("loginPage");
    return model;
}
	@RequestMapping(value = "/userLogin",method = RequestMethod.POST )
    public String userLogin(@ModelAttribute("user") User user,
           Model model,HttpSession session){
		User loggedinUser;
			try {
			loggedinUser = userService.login(user);
			//login is success
			if(loggedinUser.getRoll().equals(UserDao.ADMIN)) {
				//if login user is admin
				addUserSession(loggedinUser,session);
				return "redirect:adminDashBd";
				}else if(loggedinUser.getRoll().equals(UserDao.USER)){
				//if login user is user
				addUserSession(loggedinUser,session);
				return "redirect:userDashBd";
			}else {
				
				//if login user is guest
				 return null;
			}
			
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return null;
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "redirect:loginForm?act=nul";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			
			return null;
		}
    } 
	@RequestMapping(value = "/logout",method = RequestMethod.GET )
    public String logout( HttpSession session) {
    		session.invalidate();  		
    return "redirect:loginForm?act=lo";
    }
	
//======================================DashBds==============================================	
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
	    
//==================================loginRegForm=====================================================	    
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
	    		return "loginRegForm";
	         }else {
	    	    	try {
							user.setLoginStatus(1);
                            user.setRoll(2);
							userService.Registration(user);
							return "redirect:loginForm?act=reg";
						} catch (PersistenceException e) {
							// TODO Auto-generated catch block
							
							e.printStackTrace();
							model.addAttribute("err","LoginName already existed please select another name");
							 return "loginRegForm";
						}catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							 return "redirect:loginForm";
						}
	         }
    }
	    
	    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
		  public ModelAndView changeStatus(@RequestParam("a") Integer uid,@RequestParam("b") Integer lstatus) {
		ModelAndView model =new ModelAndView();
		System.out.println("uid="+uid+"  lstatus="+lstatus);
		User user=new User();
		user.setUserId(uid);
		user.setLoginStatus(lstatus);
		try {
			userService.changeLoginStsatus(user);
			System.out.println(">>>>>>>>>>>>>>>");
			model.addObject("err","SUCCESS :logIn user status is changed...");
			    return model;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(">.....................>");
			model.addObject("err","FAIL:logIn user status is not changed... ");
			return model;
		}  
		  }
	    
	    @RequestMapping(value = "/changeRoll", method = RequestMethod.POST)
		  public ModelAndView changeRoll(@RequestParam("a") Integer uid,@RequestParam("b") Integer roll) {
		ModelAndView model =new ModelAndView();
		System.out.println("uid="+uid+"  roll="+roll);
		User user=new User();
		user.setUserId(uid);
		user.setRoll(roll);
		try {
			userService.changeRoll(user);
			
			model.addObject("err","SUCCESS :logIn user status is changed...");
			    return model;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			model.addObject("err","FAIL:logIn user status is not changed... ");
			return model;
		}  
		  }
	    
	    @RequestMapping(value = "/loginPWDChange", method = RequestMethod.GET)
		  public ModelAndView changePWD() {
		ModelAndView model =new ModelAndView();
		 User user=new User();
	      model.addObject("user", user);
		model.setViewName("loginPWDChange");
		return model;
	    }
	    @RequestMapping(value = "/forNewPWD", method = RequestMethod.POST)
		  public ModelAndView forNewPWD(@ModelAttribute("user") User user) {
		ModelAndView model =new ModelAndView();
		System.out.println("new pwd........=="+user.getPassword());
		user.getLoginName();
		try {
			if(user.equals(null)) {
				model.addObject("err", "Enter valid password...");
				model.setViewName("loginPWDChange");
				return model;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			User dbuser=userService.selectLoginName(user);
			if(dbuser.equals(null)) {
				model.addObject("err", "you can not find this Login Name...Please Registar ");
				model.setViewName("loginPWDChange");
				return model;
			}else {
		       
				dbuser.setPassword(user.getPassword());
				userService.updateUserPWD(dbuser);
				//model.addObject("user", user);
				model.addObject("error", "SUCCESS: You have changed your password. plz...  Login with new password.");
			    model.setViewName("loginPage");
			    return model;
			}
			
		
		} catch (java.lang.NullPointerException e) {
			model.addObject("err", "you can not find this Login Name...Please Registar ");
			model.setViewName("loginPWDChange");
			return model;
		}catch (Exception e) {
			model.addObject("user", user);
			model.setViewName("loginPWDChange");
			return model;
		}
		}
	    
	    @RequestMapping(value = "/example", method = RequestMethod.GET)
		  public ModelAndView example() {
		ModelAndView model =new ModelAndView();
		 User user=new User();
	      model.addObject("user", user);
		model.setViewName("loginPWDChange");
		return model;
	    }
	    
}
