package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.User;
import com.nagarro.model.userdata.Hash;

/**
 * @author mayankgangwar
 * class to authenticate the user
 */
@Component
public class AuthenticateUser {
	@Autowired
	SessionFactory sessionFactory;
	/**
	 *  function to verify the details entered by user
	 * @param uname unique id of user
	 * @param password of user account
	 * @return object of user if exists else null
	 */
	@Transactional
	public User authenticate(String uname,String password)
	{
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		String pswHash = Hash.hash(password);
		user = session.get(User.class,uname);
		if(user == null)
			return null;
		else
		{
			if(user.getPassword().equals(pswHash))
			{
				return user;
			}
			else
				return null;
		}
	}
}
