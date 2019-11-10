package com.nagarro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Flight;

/**
 * @author mayankgangwar
 * class to search the flight matching the user given specifications
 */
@Component
public class FlightSearch {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public ArrayList<Flight> findAll(String dep, String arr, String flightdate,String flightClass, String output)
	{
		ArrayList<Flight> flights = new ArrayList<>();
		
		Session session = sessionFactory.getCurrentSession();

//		System.out.println(dep+" "+arr+" "+flightdate+" "+flightClass+" "+output);
		String query=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(flightdate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		} 
		
		if(output.equals("Fare"))
            query= "from Flight where depLoc=:dep and arrLoc=:arr and validTill>=:date and flightClass like :cls order by fare";
            
        else 
         	query= "from Flight where depLoc=:dep and arrLoc=:arr and validTill>=:date and flightClass like :cls order by fare,flightDur";       
          
		try {
			TypedQuery<Flight> q = session.createQuery(query);
			q.setParameter("dep", dep);
			q.setParameter("arr", arr);
			q.setParameter("date", date);
			q.setParameter("cls", "%"+flightClass+"%");
			flights = (ArrayList)q.getResultList();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
//		if(output.equals("FARE"))
//			query="from Flight where depLoc = '"+dep
//				+"' and arrLoc = '"	+arr
//				+"' and flightClass like '%"+flightClass+"%' and date(validTill) >= '"+ flightdate 
//				+"' order by fare";
//		else
//			query="from Flight where depLoc = '"+dep
//				+"' and arrLoc = '"+arr
//				+"' and flightClass like '%"+flightClass+"%' and date(validTill) >= '" + flightdate 
//				+"' order by fare,flightDur";
//
//		TypedQuery<Flight> q = session.createQuery(query);
//		flights = (ArrayList)q.getResultList();
//		System.out.println("inside search");
		return flights;
	}
}
