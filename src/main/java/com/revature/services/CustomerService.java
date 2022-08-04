package com.revature.services;

import com.revature.models.*;
import java.util.Scanner;
public class CustomerService {
	private Scanner scan = new Scanner(System.in);
	
	public CustomerService() {
		// Empty Constructor
	}
	
	/**
	 * This adds an account
	 */
	public void addAccount(Customer person) {
		
		
		System.out.println("Enter what type of account you want to open. Enter 0 for checking,"
				+ " 1 for savings, 2 for investment");
		
		int num = scan.nextInt();
		
		if(num > 2 || num < 0) {
			System.out.println("Please enter the correct number: ");
			num = scan.nextInt();
		}
		
		String[] types = {"checking", "savings", "investment"};
		
		if(num == 0 && person.getChecking() == 0) {
			Account acc = new Account("1", person.getCustomerID(), types[num], "approved", 0);
			
			//adds this in the SQL Account Table
		}
		else if(num == 1 && person.getSavings() == 0) {
			Account acc = new Account("1", person.getCustomerID(), types[num], "approved", 0);
			
			//adds this in the SQL Account Table
		}
		else if(num == 2 && person.getInvestment() == 0) {
			Account acc = new Account("1", person.getCustomerID(), types[num], "pending", 0);
			
			//adds this in the SQL Account Table
		}
		else {
			System.out.println("Sorry you already have this type of account");
		}
		
		if(num != 2) {
			System.out.println("You have successfully created a " + types[num] + " account!");
		} else {
			System.out.println("Your investment account is pending");
		}
		
	}
	
	/**
	 * This deletes an account
	 */
	public void closeAccount(Customer person) {

		System.out.println("Enter what type of account you want to close. Enter 0 for checking,"
				+ " 1 for savings, 2 for investment");
		
		int num = scan.nextInt();
		
		if(num > 2 || num < 0) {
			System.out.println("Please enter the correct number: ");
			num = scan.nextInt();
		}
		
		String[] types = {"checking", "savings", "investment"};
		
		if(num == 0 && person.getChecking() != 0) {
			person.setChecking(0);
			//deletes this in the SQL Account Table
		} else if(num == 1 && person.getSavings() != 0) {	
			person.setSavings(0);
			//deletes this in the SQL Account Table
		} else if(num == 2 && person.getInvestment() != 0) {	
			person.setInvestment(0);
			//deletes this in the SQL Account Table
		} else {
			System.out.println("Sorry you don't have this type of account to begin with");
		}
		
		System.out.println("You have successfully deleted your " + types[num] + " account!");
			
	}
	
}
