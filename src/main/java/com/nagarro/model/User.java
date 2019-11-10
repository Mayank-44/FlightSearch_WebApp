package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author mayankgangwar 
 * 
 * 	User class which represents all the fields presented in
 *         user table in DB
 */
@Entity
public class User {

	@Id
	private String username; // username working as an primary key
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
