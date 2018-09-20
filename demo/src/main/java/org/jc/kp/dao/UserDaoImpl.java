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
	
	public void Registration(User user) {
		// TODO Auto-generated method stub
		currentSession().saveOrUpdate(user);
		
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		String LoginName=user.getLoginName();
		String password=user.getPassword();		
		String sql="select u from User u where u.LoginName=:ln and u.password=:pw";
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
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			return null;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		// TODO Auto-generated method stub
		
		return (List<User>)currentSession().createQuery("from User").list();
	}

	public void changeLoginStsatus(User user) {
		// TODO Auto-generated method stub
		
	}

}
