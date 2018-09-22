package org.jc.kp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jc.kp.model.User;
import org.jc.kp.utils.UserBlockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	
	@Autowired
	private	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void Registration(User user) {
		// TODO Auto-generated method stub
		currentSession().saveOrUpdate(user);
		
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String LoginName=user.getLoginName();
		String password=user.getPassword();		
		String sql="select u from User u where u.loginName=:ln and u.password=:pw";
		Map<String, String> m=new HashMap<String, String>();
		m.put("ln",LoginName);
		m.put("pw",password);
		try {
			user = (User) currentSession().createQuery(sql).setProperties(m).uniqueResult();
			
			if(user.getLoginStatus().equals(LOGIN_STATUS_BLOCKED)) {
				throw new  UserBlockedException("Your account has been blocked please contact your admin.");
			}else {
				return user;
			}
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			
			
			return null;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		
		return (List<User>)currentSession().createQuery("from User").list();
	}

	@Override
	public void changeLoginStsatus(User user) {
		Integer x=user.getUserId();
		Integer y=user.getLoginStatus();
		User u= (User) currentSession().load(User.class,x);
		u.setLoginStatus(y);
				currentSession().update(u);
	}

	@Override
	public void changeRoll(User user) {
		// TODO Auto-generated method stub
		Integer x=user.getUserId();
		Integer y=user.getRoll();
		User u= (User) currentSession().load(User.class,x);
		u.setRoll(y);
		currentSession().update(u);
	}

	@Override
	public User selectLoginName(User user) {
		// TODO Auto-generated method stub
		String LoginName=user.getLoginName();
		String sql="select u from User u where u.loginName=:ln ";
		Map<String, String> m=new HashMap<String, String>();
		m.put("ln",LoginName);
		try {
			user = (User) currentSession().createQuery(sql).setProperties(m).uniqueResult();
			
			if(user.getLoginStatus().equals(LOGIN_STATUS_BLOCKED)) {
				throw new  UserBlockedException("Your account has been blocked please contact your admin.");
			}else {
				return user;
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			
			
			return null;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void updateUserPWD(User user) {
		Integer x=user.getUserId();
		String psw=user.getPassword();
		User u= (User) currentSession().load(User.class,x);
		u.setPassword(psw);
				currentSession().update(u);
	}

}
