package com.revature.controllers;

import java.util.Scanner;
import java.util.List;


import com.revature.models.*;
import com.revature.services.AdminService;
import com.revature.services.CustomerService;


public class AdminController {
	private Scanner scan = new Scanner(System.in);
	private MenuController menu = new MenuController();
	private AdminService adminService = new AdminService();
	private CustomerService customerService = new CustomerService();
	
	/**
	 * This is the admin menu
	 */
	public void adminMenu() {
		System.out.print("Enter your username: ");
		String username = scan.nextLine();
		System.out.print("Enter your password: ");
		String password = scan.nextLine();

		Admin person = adminService.getAdmin(username, password);
		
		System.out.println("Welcome Admin: " + person.getName());
		actions();
	}
	

	/**
	 * These are the actions to do as admin
	 */
	public void actions() {
		System.out.println("What would you like to do?\n"
       		 + "1. See total customer records\n"
       		 + "2. See total account records\n"
       		 + "3. See customer and their accounts\n"
       		 + "4. Deny/Approve applications\n"
       		 + "5. Handle customer transactions\n"
       		 + "6. Quit admin menu\n");
		String answer = scan.nextLine();
		switch(answer) {
			case "1":
				seeCustomerRecords();
				actions();
				break;
			case "2":
				seeAccountRecords();
				actions();
				break;
			case "3":
				seeCustomerAndAccounts();
				actions();
				break;
			case "4":
				seePending();
				decide();
				actions();
				break;
			case "5":
				customerActions();
				actions();
				break;
			case "6":
				menu.mainMenu();
				break;
			
			default:
				System.out.println("Sorry that is not a valid input please try again. ");
				actions();
		}
	}
	
	/**
	 * see total customer records
	 */
	public void seeCustomerRecords() {
		List<Customer> list = adminService.seeAllCustomers();
		System.out.println("Here are the customer records");
		for(Customer a:list){
			System.out.println(a);
			
		}
	}
	
	/**
	 * See total account records
	 */
	public void seeAccountRecords() {
		List<Account> list = adminService.seeAllAccounts();
		System.out.println("Here are all the financial accounts records");
		for(Account a: list) {
			System.out.println(a);
		}
	}
	
	/**
	 * See customer and their accounts
	 */
	public void seeCustomerAndAccounts() {
		System.out.println("Which customer and their accounts do you want to see? \n"
				          + "Choose by customerID");
		String id = scan.nextLine();
		Customer person = adminService.getCustomer(Integer.parseInt(id));
		if(person == null) {
			System.out.println("customerID does not exist");
			return;
		}
		List<Account> list = adminService.seeAccounts(Integer.parseInt(id));
		System.out.print(person);
		for(Account a: list) {
			System.out.println(a);
		}
	}
	
	/**
	 * Sees pending investment accounts for review
	 */
	public void seePending() {
		System.out.println("Here are the pending applications");
		List<Account> list = adminService.seeAllAccounts();
		
		for(Account a: list) {
			if(a.getStatus().equals("pending")) {
				System.out.println(a);
			}	
		}
		
			
	}
	
	/**
	 * Decides whether to move forward with the pending accounts
	 */
	public void decide() {
		System.out.println("1. To process an application\n"
				+ "2. Go back to admin menu");
		String option = scan.nextLine();
		
		switch(option) {
	    	case "1":
	    		System.out.println("Enter an accountID to process their application");
				String id = scan.nextLine();
				System.out.println("Enter approve or deny");
				String choice = scan.nextLine();
				approveOrDeny(Integer.parseInt(id), choice);
	    	case "2":
	    		actions();
	    	default:
	    		decide();
		}
	}
	
	/**
	 * Approves or denies application
	 * @param id
	 * @param answer
	 */
	public void approveOrDeny(int id, String answer) {
		
		
		if(answer.equals("approve") || answer.equals("deny")) {
			adminService.processed(id, answer);
			
		} else {
			System.out.println("Sorry wrong input");
		}
	}
	
	/**
	 * Manipulates customer accounts
	 */
	public void customerActions() {
		System.out.println("Enter existing customerid to make transactions on their account");
		String id = scan.nextLine();
		Customer person = adminService.getCustomer(Integer.parseInt(id));
		
		System.out.println("What would you like to do on their account?\n"
		        		 + "1. Deposit an amount\n"
		        		 + "2. Withdraw an amount\n"
		        		 + "3. Transfer an amount to different account\n"
		        		 + "4. Close account\n"
		        		 + "5. Quit and go back to admin menu\n");
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
				break;
			case "2":
				accounttype = whichAccount(person);
				money = amount();
				if(!check(money)) {
					customerService.withdraw(person, accounttype, money);
				}
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
				break;
			case "4":
				accounttype = whichAccount(person);
				customerService.closeAccount(person, accounttype);
				adminMenu();
				break;
			
			case "5":
				adminMenu();
			default:
				System.out.println("Sorry that is not a valid input please try again. ");
				customerActions();
			}
	}
	
	/**
	 * Returns an account type
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
	 * Returns an amount
	 * @return
	 */
	public double amount() {
		System.out.println("How much?");
		String money = scan.nextLine().trim();
		return Double.parseDouble(money);
	}
	
	/**
	 * This checks if the amount is negative or not
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
