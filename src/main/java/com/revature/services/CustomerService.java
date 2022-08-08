package com.revature.services;

import java.util.List;

import com.revature.controllers.CustomerController;
import com.revature.daos.BankDAO;
import com.revature.daos.BankDAOImpl;
import com.revature.models.*;




public class CustomerService {
	

	private BankDAO bank = new BankDAOImpl();
	public CustomerService() {
		// Empty Constructor
	}
	
	public Customer getCustomer(String username, String password) {
		Customer person = bank.getCustomer(username, password);
		return person;
	}
	
	/**
	 * This adds an account
	 */
	public void openAccount(Customer person, String accounttype) {
		String warning = "This account is already open or pending";
		if(accounttype.equals("checking")) {
			if(person.getChecking() != null) {
				System.out.println(warning);
			} else {
				bank.openAccount(person.getCustomerID(), accounttype);
			}
			
			
		} else if(accounttype.equals("savings")) {	
			if(person.getSavings() != null) {
				System.out.println(warning);
				
			} else {
				bank.openAccount(person.getCustomerID(), accounttype);
			}
			
		} else if(accounttype.equals("investment")) {	
			if(person.getInvestment() != null) {
				System.out.println(warning);
			} else {
				bank.openAccount(person.getCustomerID(), accounttype);
			}
			
		} 
		
		
	}
	
	/**
	 * This deletes an account
	 */
	public void closeAccount(Customer person, String accounttype) {
		String warning = "This account is already closed";
		if(accounttype.equals("checking")) {
			if(person.getChecking() == null) {
				System.out.println(warning);
				
			} else {
				bank.closeAccount(person.getCustomerID(), accounttype);
			}
			
		} else if(accounttype.equals("savings")) {	
			if(person.getChecking() == null) {
				System.out.println(warning);
				
			} else {
				bank.closeAccount(person.getCustomerID(), accounttype);
			}
			
		} else if(accounttype.equals("investment")) {	
			if(person.getChecking() == null) {
				System.out.println(warning);
				
			} else {
				bank.closeAccount(person.getCustomerID(), accounttype);
			}
			
		} 	
			
	}
	
	/**
	 * This is the deposit method
	 * @param person
	 * @param type
	 * @param amount
	 */
	public void deposit(Customer person, String type, double amount) {
		if(type.equals("checking")) {
			
			
			double first = person.getChecking().getAmount();
			double total = amount + first;
			
			person.getChecking().setAmount(total);
			bank.deposit(person.getCustomerID(), "checking", total);
			System.out.println("Transaction processed successfully!");
		} else if(type.equals("savings")) {
			double first = person.getSavings().getAmount();
			double total = amount + first;
			
			person.getSavings().setAmount(total);
			bank.deposit(person.getCustomerID(), "savings", total);
			System.out.println("Transaction processed successfully!");
		} else if(type.equals("investment")) {
			double first = person.getInvestment().getAmount();
			double total = amount + first;
			
			person.getInvestment().setAmount(total);
			bank.deposit(person.getCustomerID(), "investment", total);
			System.out.println("Transaction processed successfully!");
		}
	}
	
	/**
	 * This is the withdraw method
	 * @param person
	 * @param type
	 * @param amount
	 */
	public void withdraw(Customer person, String type, double amount) {
		if(type.equals("checking")) {
			double first = person.getChecking().getAmount();
			
			if(check(first, amount)) {
				double total = first - amount;
				person.getChecking().setAmount(total);
				bank.withdraw(person.getCustomerID(), "checking", total);
				System.out.println("Transaction processed successfully!");
			}
			
			
		} else if(type.equals("savings")) {
			double first = person.getSavings().getAmount();
			
			if(check(first, amount)) {
				double total = first - amount;
				person.getChecking().setAmount(total);
				bank.withdraw(person.getCustomerID(), "savings", total);
				System.out.println("Transaction processed successfully!");
			}
			// SQL add
		} else if(type.equals("investment")) {
			double first = person.getInvestment().getAmount();
	
			if(check(first, amount)) {
				double total = first - amount;
				person.getChecking().setAmount(total);
				bank.withdraw(person.getCustomerID(), "investment", total);
				System.out.println("Transaction processed successfully!");
			}
			// SQL add
		}
	} 
	
	/**
	 * This is the transfer method
	 * @param person
	 * @param type
	 * @param amount
	 */
	public void transfer(Customer person, String toAccount, String fromAccount, double amount) {
		withdraw(person, fromAccount, amount);
		deposit(person, toAccount, amount);
		//SQL
	}
	
	/**
	 * This is a check
	 */
	public boolean check(double total, double removed) {
		if(removed > total) {
			System.out.println("Sorry withdraw or transfer amount exceeds your total amount");
			return false;
		}
		return true;
	}
	
	public List<Account> seeAccounts(int customerID) {
		
		return bank.getAllAccounts(customerID);
	}
}
