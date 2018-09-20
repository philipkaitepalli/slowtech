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
	
	@Override
	public void Registration(User user) {
		// TODO Auto-generated method stub
		userDao.Registration(user);
	}

	@Override
	public User login(User user) throws UserBlockedException{
		// TODO Auto-generated method stub
		return userDao.login(user);
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public void changeLoginStsatus(User user) {
		// TODO Auto-generated method stub
		userDao.changeLoginStsatus(user);
	}

	@Override
	public void changeRoll(User user) {
		// TODO Auto-generated method stub
		userDao.changeRoll(user);
	}

	@Override
	public User selectLoginName(User user) {
		// TODO Auto-generated method stub
		return userDao.selectLoginName(user);
	}

	@Override
	public void updateUserPWD(User user) {
		// TODO Auto-generated method stub
		userDao.updateUserPWD(user);
	}

}
