package org.jc.kp.dao;

import java.util.List;

import org.jc.kp.exceptions.UserBlockedException;
import org.jc.kp.model.User;

public interface UserDao {
	   public static final Integer LOGIN_STATUS_ACTIVE=1;
	   public static final Integer LOGIN_STATUS_BLOCKED=2;
	   public static final Integer ADMIN=1;
	   public static final Integer USER=2;
	/**
	 * Registration 
	 * @param user
	 */
	    public void Registration(User user);
	    /**
	     * when user login user object shall be returned 
	     * if user object is null advise to register to login
	     * @param LoginName
	     * @param password
	     * @return
	     */
	    public User login(User user) throws UserBlockedException;
	    /**
		    * returns all registered users
		    * 
		    * @return
		    */
			public List<User> getAll();
			
			/**
			 * this method changes login user status block or active
			 * 
			 * @param user
			 */
			public void changeLoginStsatus(User user);
	
}
