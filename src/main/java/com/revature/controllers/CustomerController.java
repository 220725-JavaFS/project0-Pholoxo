package com.revature.controllers;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class CustomerController {
	private Scanner scan = new Scanner(System.in);
	private MenuController menu = new MenuController();
	private CustomerService customerService = new CustomerService();
	
	/**
	 * This is the customer menu to enter credentials
	 */
	public void customerMenu() {
		System.out.print("Enter your username: ");
		String username = scan.nextLine();
		System.out.print("Enter your password: ");
		String password = scan.nextLine();

		Customer person = customerService.getCustomer(username, password);
		
		System.out.println();
		seeAccounts(person);
		System.out.println();
		
		actions(person);
	}
	
	/**
	 * This is cutomer menu to do actions on account
	 * @param person
	 */
	public void actions(Customer person) {
		System.out.println("What would you like to do?\n"
		        		 + "1. Deposit an amount\n"
		        		 + "2. Withdraw an amount\n"
		        		 + "3. Transfer an amount to different account\n"
		        		 + "4. Close account\n"
		        		 + "5. Open account\n"
		        		 + "6. See accounts\n"
		        		 + "7. Quit customer menu\n");
		String answer = scan.nextLine();
		String accounttype = "";
		double money = 0;
		switch(answer) {
			case "1":
				accounttype = whichAccount(person);
				money = amount();
				if(!check(money)) {
					customerService.deposit(person, accounttype, money);
				}
			
				actions(person);
				break;
			case "2":
				accounttype = whichAccount(person);
				money = amount();
				if(!check(money)) {
					customerService.withdraw(person, accounttype, money);
				}
				
				actions(person);
				break;
			case "3":
				System.out.print("To ");
				accounttype = whichAccount(person);
				System.out.print("From ");
				String accounttype2 = whichAccount(person);
				money = amount();
				if(!check(money)) {
					customerService.transfer(person, accounttype, accounttype2, money);
				}
				
				actions(person);
				break;
			case "4":
				accounttype = whichAccount(person);
				customerService.closeAccount(person, accounttype);
				actions(person);
				break;
			case "5":
				accounttype = whichAccount(person);
				customerService.openAccount(person, accounttype);
				actions(person);
				break;
			case "6":
				seeAccounts(person);
				actions(person);
				break;
			case "7":
				menu.mainMenu();
			default:
				System.out.println(answer);
				System.out.println("Sorry that is not a valid input please try again. ");
				actions(person);
				break;
			}
	}
	
	/**
	 * This returns an account type
	 * @param person
	 * @return
	 */
	public String whichAccount(Customer person) {
		String option = "";
		System.out.println("Which account?\n"
				         + "1. checking\n"
				         + "2. savings\n"
				         + "3. investment");
		String answer = scan.nextLine();
		switch(answer) {
			case "1":
				option = "checking";
						
				break;
			case "2":
				option = "savings";
				
				break;
			case "3":
				option = "investment";
				
				break;	
		}
		return option;
	}
	
	/**
	 * This returns an amount
	 * @return
	 */
	public double amount() {
		System.out.println("How much?");
		String money = scan.nextLine().trim();
		return Double.parseDouble(money);
	}
	
	public void seeAccounts(Customer person) {
		
		List<Account> list = customerService.seeAccounts(person.getCustomerID());
		
		System.out.println("Here are your accounts:");
		for(Account a:list){
			System.out.println(a);
			String type = a.getAccountType();
			switch(type) {
				case "checking":
					person.setChecking(a);
					break;
				case "savings":
					person.setSavings(a);
					break;
				case "investment":
					person.setInvestment(a);
					break;
			}
		}
	}
	
	/**
	 * This checks if the amount is negative
	 * @param isNegative
	 * @return
	 */
	public boolean check(double isNegative) {
		
		if(isNegative < 0) {
			System.out.println("amount can't be below 0");
			return true;
		}
		return false;
	}
}
