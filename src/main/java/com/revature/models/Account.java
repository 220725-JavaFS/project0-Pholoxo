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
		return "Account [accountID=" + accountID + ", customerID=" + customerID + ", accountType=" + accountType
				+ ", status=" + status + ", amount=" + amount + "]";
	}	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + customerID;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountID != other.accountID)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (customerID != other.customerID)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
