package com.revature.services;


import com.revature.daos.*;
import com.revature.daos.BankDAOImpl;

/**
 * This is the regsterSerice class
 * @author maxmorales
 *
 */
public class RegisterService {
	
	private BankDAO bank = new BankDAOImpl();
	
	/**
	 * This adds a customer by name, password, and username
	 * @param name
	 * @param password
	 * @param username
	 */
	public void addCustomer(String name, String password, String username) {
		bank.addCustomer(name, password, username);
	}
	
	/**
	 * This tells if this person exists by username
	 * @param username
	 * @return
	 */
	public boolean ifExists(String username) {
		return bank.ifExists(username);
	}
}
