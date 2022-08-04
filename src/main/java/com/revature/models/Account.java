package com.revature.models; 

public class Account {
	private String accountId;
	private String customerId;
	private String accountType;
	private String status;
	private long amount;
	
	
	/**
	 * Constructor of Account Class
	 * @param accountId
	 * @param ownerId
	 * @param accountType
	 * @param amount
	 */
	public Account(String accountId, String customerId, String accountType, String status, long amount) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountType = accountType;
		this.amount = amount;
	}


	/**
	 * This returns the accountID
	 * @return
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * This sets the accountID
	 * @param accountId
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * This returns the customerID
	 * @return
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * This sets the customerID
	 * @param ownerId
	 */
	public void setCustomerId(String ownerId) {
		this.customerId = ownerId;
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
	public long getAmount() {
		return amount;
	}

	/**
	 * This sets the amount
	 * @param amount
	 */
	public void setAmount(long amount) {
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
	
	
}
