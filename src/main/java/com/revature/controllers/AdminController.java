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
	
	public void adminMenu() {
		System.out.print("Enter your username: ");
		String username = scan.nextLine();
		System.out.print("Enter your password: ");
		String password = scan.nextLine();

		Admin person = adminService.getAdmin(username, password);
		
		System.out.println("Welcome Admin: " + person.getName());
		actions();
	}
	

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
	
	public void seeCustomerRecords() {
		List<Customer> list = adminService.seeAllCustomers();
		System.out.println("Here are the customer records");
		for(Customer a:list){
			System.out.println(a);
			
		}
	}
	
	public void seeAccountRecords() {
		List<Account> list = adminService.seeAllAccounts();
		System.out.println("Here are all the financial accounts records");
		for(Account a: list) {
			System.out.println(a);
		}
	}
	
	public void seeCustomerAndAccounts() {
		System.out.println("Which customer and their accounts do you want to see? \n"
				          + "Choose by customerid");
		int id = scan.nextInt();
		Customer person = adminService.seeCustomer(id);
		List<Account> list = adminService.seeAccounts(id);
		System.out.print(person);
		for(Account a: list) {
			System.out.println(a);
		}
	}
	
	public void seePending() {
		System.out.println("Here are the pending applications");
		List<Account> list = adminService.seeAllAccounts();
		
		for(Account a: list) {
			if(a.getStatus().equals("pending")) {
				System.out.println(a);
			}	
		}
		System.out.println("1. Select an account to process\n"
				         + "2. Go back to employee menu");
		String next = scan.nextLine();
		
		switch(next) {
			case "1":
				approveOrDeny();
				
				break;
			case "2":
				adminMenu();
			default:
				System.out.println("Sorry wrong input");
				seePending();
		}
			
	}
	
	public void approveOrDeny() {
		System.out.println("Select an account");
		
		int id = scan.nextInt();
		System.out.println("1. Approve\n"
						 + "2. Deny");
		String judgement = scan.nextLine();
		switch(judgement) {
			case "1":
				adminService.processed(id, "approved");
				adminMenu();
				break;
			case "2":
				adminService.processed(id, "denied");
				adminMenu();
				break;
			default:
				System.out.println("Sorry they can't escape judgement");
				approveOrDeny();
		}
	}
	
	public void customerActions() {
		System.out.println("Enter existing customerid to make transactions on their account");
		int id = scan.nextInt();
		Customer person = adminService.seeCustomer(id);
		
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
				customerService.deposit(person, accounttype, money);
				break;
			case "2":
				accounttype = whichAccount(person);
				money = amount();
				customerService.withdraw(person, accounttype, money);
				break;
			case "3":
				System.out.print("To ");
				accounttype = whichAccount(person);
				System.out.print("From ");
				String accounttype2 = whichAccount(person);
				money = amount();
				customerService.transfer(person, accounttype, accounttype2, money);
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
	
	public double amount() {
		double money = 0;
		System.out.println("How much?");
		money = scan.nextDouble();
		
		return money;
	}
}
