package com.nagarro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author mayankgangwar class to store flight data
 */
@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id; // auto incrementing column also the primary key for the table
	private String flightNo;
	private String depLoc;
	private String arrLoc;
	private Date validTill;
	private int flightTime;
	private double flightDur;
	private double fare;
	private char seatAva;
	private String flightClass;

	public Flight() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepLoc() {
		return depLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public double getFlightDur() {
		return flightDur;
	}

	public void setFlightDur(double flightDur) {
		this.flightDur = flightDur;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public char getSeatAva() {
		return seatAva;
	}

	public void setSeatAva(char seatAva) {
		this.seatAva = seatAva;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNo=" + flightNo + ", depLoc=" + depLoc + ", arrLoc=" + arrLoc
				+ ", validTill=" + validTill + ", flightTime=" + flightTime + ", flightDur=" + flightDur + ", fare="
				+ fare + ", seatAva=" + seatAva + ", flightClass=" + flightClass + "]";
	}
	
}
