package com.revature.daos;

import com.revature.models.*;

import java.util.List;

/**
 * This is the interface that connects to the database
 * @author maxmorales
 *
 */
public interface BankDAO {
	
	
	/**
	 * returns an admin
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Admin getAdmin(String username, String password);
	
	/**
	 * This returns customer
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Customer getCustomer(String username, String password);
	
	/**
	 * This returns employee
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Employee getEmployee(String username, String password);
	
	/**
	 * This returns account
	 * @param customerID
	 * @param accounttype
	 * @return
	 */
	public abstract Account getAccountByID(int customerID, String accounttype);
	
	/**
	 * This returns customer by id
	 * @param customerID
	 * @return
	 */
	public abstract Customer getCustomerByID(int customerID);
	
	/**
	 * Deposits an amount
	 * @param customerID
	 * @param accounttype
	 * @param amount
	 */
	public abstract void deposit(int customerID, String accounttype, double amount);
	
	/**
	 * Withdraws an amount
	 * @param customerID
	 * @param accounttype
	 * @param amount
	 */
	public abstract void withdraw(int customerID, String accounttype, double amount);
	
	/**
	 * opens an account
	 * @param customerID
	 * @param accounttype
	 */
	public abstract void openAccount(int customerID, String accounttype);
	
	/**
	 * closes an amount
	 * @param customerID
	 * @param accounttype
	 */
	public abstract void closeAccount(int customerID, String accounttype);

	/**
	 * adds a customer
	 * @param name
	 * @param password
	 * @param username
	 */
	public abstract void addCustomer(String name, String password, String username);
	
	/**
	 * processes an application
	 * @param accountID
	 * @param request
	 */
	public abstract void processedApplication(int accountID, String request);
	
	/**
	 * Makes sure this customer exists by username
	 * @param username
	 * @return
	 */
	public abstract boolean ifExists(String username);
	
	/**
	 * returns all admins
	 */
	public abstract List<Admin> getAllAdmins();
	
	/**
	 * returns all customers
	 * @return
	 */
	public abstract List<Customer> getAllCustomers();
	
	/**
	 * returns all employees
	 * @return
	 */
	public abstract List<Employee> getAllEmployees();
	
	/**
	 * This returns all accounts by a single customer
	 * @param customerID
	 * @return
	 */
	public abstract List<Account> getAllAccounts(int customerID);
	
	/**
	 * This returns all total accounts
	 * @return
	 */
	public abstract List<Account> getTotalAccounts();
	
}
