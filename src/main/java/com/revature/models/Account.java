package com.revature.models; 

public class Account {
	private int accountID;
	private int customerID;
	private String accountType;
	private String status;
	private double amount;
	
	
	
	/**
	 * Constructor of Account Class
	 * @param ownerId
	 * @param accountType
	 * @param amount
	 */
	public Account(int accountID, int customerID, String accounttype, String status, double amount) {
		super();
		this.setAccountID(accountID);
		this.setCustomerID(customerID);
		this.setAccountType(accounttype);
		this.setStatus(status);
		this.setAmount(amount);
	}
	
	/**
	 * This is an empty constructor
	 */
	public Account() {
		//This is an empty constructor
	}
	
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
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
	 * This returns the account type
	 * @return
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * This sets the account type
	 * @param accountType
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * This returns the amount
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * This sets the amount
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}


	/**
	 * This gets the status
	 * @return
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * This sets the status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}	
	
	@Override
	public String toString() {
		return "Account [customerID=" + customerID + ", accountType=" + accountType + ", status=" + status + ", amount="
				+ amount + "]";
	}

	

}
