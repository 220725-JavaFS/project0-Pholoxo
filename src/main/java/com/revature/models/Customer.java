package com.revature.models;

public class Customer {
	private int customerID;
	private String name;
	private String password;
	private String username;
	private Account checking;
	private Account savings;
	private Account investment;
	
	/**
	 * This is the main constructor for customer
	 * @param customerID
	 * @param name
	 * @param password
	 * @param username
	 * @param checking
	 * @param savings
	 * @param investment
	 */
	public Customer(int customerID, String name, String password, String username, Account checking, Account savings, Account investment) {
		super();
		
		this.customerID = customerID;
		this.name = name;
		this.password = password;
		this.username = username;
		this.checking = null;
		this.savings = null;
		this.investment = null;
//		
	}
	
	

	/**
	 * This is an empty constructor
	 */
	public Customer() {
		// Empty Constructor
	}

	/**
	 * This returns the customerID
	 * @return
	 */
	public int getCustomerID() {
		return customerID;
	}
	
	/**
	 * This sets the customerID
	 * @param customerID
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	/**
	 * This returns the name of the customer
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This sets the name of the customer
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This returns the password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * This sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This returns the username
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This sets the username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * This returns the checking account
	 * @return
	 */

	public Account getChecking() {
		return checking;
	}
	
	/**
	 * This sets the checking account
	 * @param checking
	 */

	public void setChecking(Account checking) {
		this.checking = checking;
	}
	
	/**
	 * This returns the savings account
	 * @return
	 */
	public Account getSavings() {
		return savings;
	}

	/**
	 * This sets the savings account
	 * @param savings
	 */
	public void setSavings(Account savings) {
		this.savings = savings;
	}
	
	/**
	 * This returns the investment account
	 * @return
	 */
	public Account getInvestment() {
		return investment;
	}

	/**
	 * This sets the investment account
	 * @param investment
	 */
	public void setInvestment(Account investment) {
		this.investment = investment;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", password=" + password + ", username="
				+ username + ", checking=" + checking + ", savings=" + savings + ", investment=" + investment + "]";
	}
	
	
}
