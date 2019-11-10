package com.nagarro.model.flightdata;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.nagarro.dao.FlightPersist;
import com.nagarro.model.Flight;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * @author mayankgangwar
 * class to collect all CSV files data to HashMap
 */
public class Reader {
	public static String DPATH = "src/main/java/com/nagarro/model/flightfiles/";
	
	/**
	 * @param filename of CSV
	 * @return arrayList to flight data
	 */
	public ArrayList<String[]> readCSVFileData(String filename)
	{
		ArrayList<String[]> newCSVData = null;
		FileReader filereader = null;
		try {
			 filereader = new FileReader(filename);
			
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader csvreader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();
			
			try {
				newCSVData = (ArrayList<String[]>) csvreader.readAll();
			} catch (IOException e) {
				System.out.println("Error in reading "+ filename +" file data.");
			} 
		} catch (FileNotFoundException e) {
			System.out.println(filename + " file not found.");
		}
		finally {
			if(filereader != null)
				try {
					filereader.close();
				} catch (IOException e) {
					System.out.println("Input/Output Exception caught");
				}
		}
		
		return newCSVData;
	}

	public void createFlightDB()
	{
		// retrieving CSV file names in chosen directory
		ArrayList<String> filenames = FileScanner.scanCSVFiles(DPATH);
		
    	// allData ArrayList stores all flight data in form of string array
    	ArrayList<String[]> allData = new ArrayList<String[]>();
    	
    	// reading CSV file data in ArrayList
    	for(String file : filenames)
    		allData.addAll(readCSVFileData(DPATH+file));
    	
    	Flight flight = null;
    	FlightPersist flightpersist = new FlightPersist();
    	String pattern = "dd-MM-yyy";
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        for (String[] row : allData) 
        { 
        	flight = new Flight();
    		flight.setFlightNo(row[0]);
    		flight.setDepLoc(row[1]);
    		flight.setArrLoc(row[2]);
    		try {
				flight.setValidTill(sdf.parse(row[3]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		flight.setFlightTime(Integer.parseInt(row[4]));
    		flight.setFlightDur(Double.parseDouble(row[5]));
    		flight.setFare(Double.parseDouble(row[6]));
    		flight.setSeatAva(row[7].charAt(0));
    		flight.setFlightClass(row[8]);
    		flightpersist.saveFlight(flight);
        }
	}
}
