package com.nagarro.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Flight;
import com.nagarro.service.SessionProvider;

/**
 * @author mayankgangwar
 * class to store the flight object to the DB
 */

@Component
public class FlightPersist {

//	@Autowired
//	SessionFactory sessionFactory;
	/**
	 * function to save the flight
	 * @param f flight object
	 */
	
	@Transactional
	public void saveFlight(Flight f)
	{
		Session session = SessionProvider.getSession();
//		Session session = sessionFactory.getCurrentSession();
		Transaction tns = session.beginTransaction();
		session.save(f);
		tns.commit();
		session.close();
	}
}
