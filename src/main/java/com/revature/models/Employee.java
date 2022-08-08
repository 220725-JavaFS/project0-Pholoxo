package com.revature.models;

public class Employee {
	private String employeeID;
	private String name;
	private String password;
	private String username;
	
	/**
	 * This is the main constructor for employee
	 * @param employeeID
	 * @param name
	 * @param password
	 * @param username
	 */
	public Employee(String employeeID, String name, String password, String username) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.password = password;
		this.username = username;
	}

	/**
	 * This returns employeeID
	 * @return
	 */
	public String getEmployeeID() {
		return employeeID;
	}
	
	/**
	 * This sets employeeID
	 * @param employeeID
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	/**
	 * This return name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This sets name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This returns password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This sets password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This return username
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This sets username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
