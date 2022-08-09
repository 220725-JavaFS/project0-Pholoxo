package com.revature.models;

public class Admin {
	private int adminID;
	private String name;
	private String password;
	private String username;
	
	/**
	 * 
	 * @param adminID
	 * @param name
	 * @param password
	 * @param username
	 */
	public Admin(int adminID, String name, String password, String username) {
		super();
		this.adminID = adminID;
		this.name = name;
		this.password = password;
		this.username = username;
	}
	
	/**
	 * This returns the adminID
	 * @return
	 */
	public int getAdminID() {
		return adminID;
	}
	
	/**
	 * This sets the adminID
	 * @param adminID
	 */
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	/**
	 * This returns the name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This sets the name
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
	 * This sets the name
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
