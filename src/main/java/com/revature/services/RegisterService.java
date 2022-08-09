package com.revature.services;


import com.revature.daos.*;
import com.revature.daos.BankDAOImpl;
public class RegisterService {
	
	private BankDAO bank = new BankDAOImpl();
	
	
	public void addCustomer(String name, String password, String username) {
		bank.addCustomer(name, password, username);
	}
	
	public boolean ifExists(String username) {
		return bank.ifExists(username);
	}
}
