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
	
	/**
	 * This is the tostring method that prints out its fields
	 */
	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", name=" + name + ", password=" + password + ", username=" + username
				+ "]";
	}
	
	/**
	 * This is the hashcode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/**
	 * This is the equal methods
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminID != other.adminID)
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
