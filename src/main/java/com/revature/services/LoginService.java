package com.revature.services;

import com.revature.models.*;
import com.revature.daos.*;
import com.revature.daos.BankDAOImpl;
public class LoginService {
	
	private BankDAO bank = new BankDAOImpl();
	/**
	 * This is the sign in method
	 * @param pass
	 * @param user
	 * @param role
	 */
	public boolean signin(String username, String password, String role) {
		String failed = "Wrong username or Password";
		
		if(role.equals("admin")) {
			try {
				Admin admin = bank.getAdmin(username, password);
				
			}
			catch(Exception e) {
				System.out.println(failed);
			}
		}
		
		else if(role.equals("customer")) {
			try {
				
				Customer customer = bank.getCustomer(username, password);
				System.out.println("Hello " + customer.getName() + "!");
				return true;
			}
			catch(Exception e) {
				
				System.out.println(failed);
			}
		}
		else if(role.equals("employee")) {
			try {
				Employee employee = bank.getEmployee(username, password);
				
				
			}
			catch(Exception e) {
				System.out.println(failed);
			}
		}
		return false;
	}
	
	
}
