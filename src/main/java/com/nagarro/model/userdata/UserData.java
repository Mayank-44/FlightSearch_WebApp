package com.nagarro.model.userdata;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.model.User;
import com.nagarro.service.SessionProvider;

/**
 * @author mayankgangwar
 * Class to populate the DB with dummy data to test.
 */
public class UserData 
{
    public static void main( String[] args )
    {
    	String psw="";
    	User user = null;
    	Session session = SessionProvider.getSession();
    	for(int i=1;i<=10;i++)
    	{
    		Transaction tns = session.beginTransaction();
    		
    		user = new User();
    		user.setUsername("Name_"+i);
    		psw = Hash.hash("password_"+i);
    		user.setPassword(psw);
    		session.save(user);
    		tns.commit();
    	}
    	session.close();
    }
}
