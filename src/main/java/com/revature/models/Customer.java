package com.revature.models;
import java.util.Scanner;

public class Customer {
	private String customerID;
	private String name;
	private String password;
	private String username;
	private int checking;
	private int savings;
	private int investment;
	private Scanner scan = new Scanner(System.in);
	
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
	public Customer(String customerID, String name, String password, String username, int checking, int savings, int investment) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.password = password;
		this.username = username;
		this.setChecking(checking);
		this.setSavings(savings);
		this.setInvestment(investment);
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
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * This sets the customerID
	 * @param customerID
	 */
	public void setCustomerID(String customerID) {
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
	

	public int getChecking() {
		return checking;
	}

	public void setChecking(int checking) {
		this.checking = checking;
	}

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
	}

	public int getInvestment() {
		return investment;
	}

	public void setInvestment(int investment) {
		this.investment = investment;
	}	
	
}
