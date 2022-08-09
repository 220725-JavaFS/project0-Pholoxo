package com.revature.daos;

import com.revature.models.*;

import java.util.List;

public interface BankDAO {
	
	
	
	
		
	public abstract Admin getAdmin(String username, String password);
	
	public abstract Customer getCustomer(String username, String password);
	
	public abstract Employee getEmployee(String username, String password);
	
	public abstract Account getAccountByID(int customerID, String accounttype);
	
	public abstract Customer getCustomerByID(int customerID);
	
	public abstract void deposit(int customerID, String accounttype, double amount);
	
	public abstract void withdraw(int customerID, String accounttype, double amount);
	
	public abstract void openAccount(int customerID, String accounttype);
	
	public abstract void closeAccount(int customerID, String accounttype);

	public abstract void addCustomer(String name, String password, String username);
	
	public abstract void processedApplication(int accountID, String request);
	
	public abstract boolean ifExists(String username);
	
	public abstract List<Admin> getAllAdmins();
	
	public abstract List<Customer> getAllCustomers();
	
	public abstract List<Employee> getAllEmployees();
	
	List<Account> getAllAccounts(int customerID);
	
	List<Account> getTotalAccounts();
	
}
