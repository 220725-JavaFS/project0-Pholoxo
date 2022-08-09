package com.revature.services;

import java.util.List;

import com.revature.daos.BankDAO;
import com.revature.daos.BankDAOImpl;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;

public class EmployeeService {
	private BankDAO bank = new BankDAOImpl();
	public EmployeeService() {
		//empty constructor
	}
	
	public Employee getEmployee(String username, String password) {
		Employee person = bank.getEmployee(username, password);
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
}
