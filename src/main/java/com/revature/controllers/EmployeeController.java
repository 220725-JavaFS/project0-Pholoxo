package com.revature.controllers;

import java.util.Scanner;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;


public class EmployeeController {
	private Scanner scan = new Scanner(System.in);
	private MenuController menu = new MenuController();
	private EmployeeService employeeService = new EmployeeService();
	
	public void employeeMenu() {
		System.out.print("Enter your username: ");
		String username = scan.nextLine();
		System.out.print("Enter your password: ");
		String password = scan.nextLine();

		Employee person = employeeService.getEmployee(username, password);
		System.out.println("Welcome employee: " + person.getName());
		actions();
	}
	
	public void actions() {
		System.out.println("What would you like to do?\n"
       		 + "1. See total customer records\n"
       		 + "2. See total account records\n"
       		 + "3. See customer and their accounts\n"
       		 + "4. Deny/Approve applications\n"
       		 + "5. Quit employee menu\n");
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
				menu.mainMenu();
				break;
			
			default:
				System.out.println("Sorry that is not a valid input please try again. ");
				actions();
		}
	}
	
	public void seeCustomerRecords() {
		List<Customer> list = employeeService.seeAllCustomers();
		System.out.println("Here are the customer records");
		for(Customer a:list){
			System.out.println(a);
			
		}
	}
	
	public void seeAccountRecords() {
		List<Account> list = employeeService.seeAllAccounts();
		System.out.println("Here are all the financial accounts records");
		for(Account a: list) {
			System.out.println(a);
		}
	}
	
	public void seeCustomerAndAccounts() {
		System.out.println("Which customer and their accounts do you want to see? \n"
				          + "Choose by customerid");
		int id = scan.nextInt();
		Customer person = employeeService.seeCustomer(id);
		List<Account> list = employeeService.seeAccounts(id);
		System.out.print(person);
		for(Account a: list) {
			System.out.println(a);
		}
	}
	
	public void seePending() {
		System.out.println("Here are the pending applications");
		List<Account> list = employeeService.seeAllAccounts();
		
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
				employeeMenu();
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
				employeeService.processed(id, "approved");
				employeeMenu();
				break;
			case "2":
				employeeService.processed(id, "denied");
				employeeMenu();
				break;
			default:
				System.out.println("Sorry they can't escape judgement");
				approveOrDeny();
		}
	}
	
}
