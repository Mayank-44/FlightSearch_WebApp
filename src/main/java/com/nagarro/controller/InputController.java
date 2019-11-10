package com.nagarro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Flight;
import com.nagarro.service.FlightSearch;


/**
 * @author mayankgangwar
 * class to handle the input of client
 */
@Controller
public class InputController {
	@Autowired
	FlightSearch fs;
	
	@RequestMapping(value="input",method=RequestMethod.POST)
	public ModelAndView doPost(@RequestParam("dep") String dep,@RequestParam("arr") String arr
							,@RequestParam("flightdate") String flightdate,@RequestParam("flightclass") String flightclass
							,@RequestParam("output") String output
							,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ArrayList<Flight> flights = null;
		try {
			flights = fs.findAll(dep.toUpperCase(), arr.toUpperCase(), flightdate, flightclass.toUpperCase(), output.toUpperCase());
		}
		catch(Exception e) {
//			e.printStackTrace();
			System.out.println("Error in InputController while searching for flights.");
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("flights",flights);
		mv.setViewName("output.jsp");
		if(flights == null)
				System.out.println("flight null");
//		request.setAttribute("flights", flights);
//		request.getRequestDispatcher("output.jsp").forward(request, response);
		return mv;
	}
}
