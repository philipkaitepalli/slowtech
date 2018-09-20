package org.jc.kp.service;

import java.util.List;

import org.jc.kp.dao.UserDao;
import org.jc.kp.exceptions.UserBlockedException;
import org.jc.kp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	public UserDao userDao;
	
	
	public void Registration(User user) {
		// TODO Auto-generated method stub
		userDao.Registration(user);
	}


	public User login(User user) throws UserBlockedException{
		// TODO Auto-generated method stub
		return userDao.login(user);
		
	}


	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public void changeLoginStsatus(User user) {
		// TODO Auto-generated method stub
		
	}

}
