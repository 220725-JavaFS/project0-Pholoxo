package com.revature.services;

import java.util.List;

import com.revature.daos.BankDAO;
import com.revature.daos.BankDAOImpl;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;

/**
 * This is the employee service class
 * @author maxmorales
 *
 */
public class EmployeeService {
	private BankDAO bank = new BankDAOImpl();
	
	public EmployeeService() {
		//empty constructor
	}
	
	/**
	 * This returns an employee 
	 * @param username
	 * @param password
	 * @return
	 */
	public Employee getEmployee(String username, String password) {
		Employee person = bank.getEmployee(username, password);
		return person;
	}
	
	/**
	 * This sees all customers
	 * @return
	 */
	public List<Customer> seeAllCustomers() {
		
		return bank.getAllCustomers();
	}
	
	/**
	 * This sees all accounts
	 * @return
	 */
	public List<Account> seeAllAccounts() {
		return bank.getTotalAccounts();
	}
	
	/**
	 * This sees a customer by id
	 * @param customerID
	 * @return
	 */
	public Customer seeCustomer(int customerID) {
		return bank.getCustomerByID(customerID);
	}
	
	/**
	 * This sees all accounts by customer id
	 * @param customerID
	 * @return
	 */
	public List<Account> seeAccounts(int customerID) {
		return bank.getAllAccounts(customerID);
	}
	
	/**
	 * This processes an application
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

}
