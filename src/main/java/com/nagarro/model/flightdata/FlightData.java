package com.nagarro.model.flightdata;

/**
 * @author mayankgangwar
 * class to create FLIGHT DATA from CSV files
 */
public class FlightData {
	
	public static void main(String[] args) {
		Reader reader = new Reader();
		reader.createFlightDB();
	}
}
