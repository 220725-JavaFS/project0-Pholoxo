package com.revature.services;

import java.util.List;

import com.revature.daos.BankDAO;
import com.revature.daos.BankDAOImpl;
import com.revature.models.Account;
import com.revature.models.Admin;
import com.revature.models.Customer;

/**
 * This is the admin service class
 * @author maxmorales
 *
 */
public class AdminService {
	private BankDAO bank = new BankDAOImpl();
	
	public AdminService() {
		// empty constructor
	}
	
	/**
	 * This returns an admin and sees if they exist
	 * @param username
	 * @param password
	 * @return
	 */
	public Admin getAdmin(String username, String password) {
		Admin person = bank.getAdmin(username, password);
		return person;
	}
	
	/**
	 * This return a list of customers
	 * @return
	 */
	public List<Customer> seeAllCustomers() {
		
		return bank.getAllCustomers();
	}
	
	/**
	 * This returns a list of accounts
	 * @return
	 */
	public List<Account> seeAllAccounts() {
		return bank.getTotalAccounts();
	}
	
	/**
	 * This returns a customer by id
	 * @param customerID
	 * @return
	 */
	public Customer getCustomer(int customerID) {
		return bank.getCustomerByID(customerID);
	}
	
	/**
	 * This sees all accounts of all customers
	 * @param customerID
	 * @return
	 */
	public List<Account> seeAccounts(int customerID) {
		return bank.getAllAccounts(customerID);
	}
	
	/**
	 * This method processes an application
	 * @param accountID
	 * @param request
	 */
	public void processed(int accountID, String request) {
		if(request.equals("approve")) {
			bank.processedApplication(accountID, "open");
			System.out.println("This account has been approved");
		} else {
			bank.processedApplication(accountID, "denied");
			System.out.println("This account has been denied");
		}
	}
	
	/**
	 * This closes an account of checking, savings, or investment
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
