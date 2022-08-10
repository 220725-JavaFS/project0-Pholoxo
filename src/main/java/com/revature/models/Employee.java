package com.revature.models;

public class Employee {
	private int employeeID;
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
	public Employee(int employeeID, String name, String password, String username) {
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
	public int getEmployeeID() {
		return employeeID;
	}
	
	/**
	 * This sets employeeID
	 * @param employeeID
	 */
	public void setEmployeeID(int employeeID) {
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
	
	/**
	 * This is the tostring method that prints all of its fields
	 */
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", password=" + password + ", username="
				+ username + "]";
	}

	/**
	 * This is the hashcode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	/**
	 * This is the equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
