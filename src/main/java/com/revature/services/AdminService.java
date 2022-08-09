package com.revature.services;

import java.util.List;

import com.revature.daos.BankDAO;
import com.revature.daos.BankDAOImpl;
import com.revature.models.Account;
import com.revature.models.Admin;
import com.revature.models.Customer;


public class AdminService {
	private BankDAO bank = new BankDAOImpl();
	
	public AdminService() {
		// empty constructor
	}
	
	public Admin getAdmin(String username, String password) {
		Admin person = bank.getAdmin(username, password);
		return person;
	}
	
	public List<Customer> seeAllCustomers() {
		
		return bank.getAllCustomers();
	}
	
	public List<Account> seeAllAccounts() {
		return bank.getTotalAccounts();
	}
	
	public Customer seeCustomer(int customerID) {
		return bank.getCustomerByID(customerID);
	}
	
	public List<Account> seeAccounts(int customerID) {
		return bank.getAllAccounts(customerID);
	}
	
	public void processed(int accountID, String request) {
		bank.processedApplication(accountID, request);
	}
	
	public void getCustomerByID(int customerID) {
		bank.getCustomerByID(customerID);
	}
	/**
	 * This deletes an account
	 */
	public void closeAccount(Customer person, String accounttype) {
		String warning = "This account is already closed";
		if(accounttype.equals("checking")) {
			if(person.getChecking() == null) {
				System.out.println(warning);
				
			} else {
				bank.closeAccount(person.getCustomerID(), accounttype);
				System.out.println("Transaction processed successfully!");
			}
			
		} else if(accounttype.equals("savings")) {	
			if(person.getChecking() == null) {
				System.out.println(warning);
				
			} else {
				bank.closeAccount(person.getCustomerID(), accounttype);
				System.out.println("Transaction processed successfully!");
			}
			
		} else if(accounttype.equals("investment")) {	
			if(person.getChecking() == null) {
				System.out.println(warning);
				
			} else {
				bank.closeAccount(person.getCustomerID(), accounttype);
				System.out.println("Transaction processed successfully!");
			}
			
		} 	
			
	}
}
