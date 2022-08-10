package com.revature.controllers;

import java.util.Scanner;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

/**
 * This is the employee class
 * @author maxmorales
 *
 */
public class EmployeeController {
	private Scanner scan = new Scanner(System.in);
	private MenuController menu = new MenuController();
	private EmployeeService employeeService = new EmployeeService();
	
	/**
	 * This is the employee menu
	 */
	public void employeeMenu() {
		System.out.print("Enter your username: ");
		String username = scan.nextLine();
		System.out.print("Enter your password: ");
		String password = scan.nextLine();

		Employee person = employeeService.getEmployee(username, password);
		System.out.println("Welcome employee: " + person.getName());
		actions();
	}
	
	/**
	 * This goes to the menu instructions
	 */
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
				decide();
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
	
	/**
	 * This sees all customers
	 */
	public void seeCustomerRecords() {
		List<Customer> list = employeeService.seeAllCustomers();
		System.out.println("Here are the customer records");
		for(Customer a:list){
			System.out.println(a);
			
		}
		System.out.println();
	}
	
	/**
	 * This sees all accounts
	 */
	public void seeAccountRecords() {
		List<Account> list = employeeService.seeAllAccounts();
		System.out.println("Here are all the financial accounts records");
		for(Account a: list) {
			System.out.println(a);
		}
	}
	
	/**
	 * This sees a customer and their accounts
	 */
	public void seeCustomerAndAccounts() {
		System.out.println("Which customer and their accounts do you want to see? \n"
				          + "Choose by customerid");
		String id = scan.nextLine();
		Customer person = employeeService.seeCustomer(Integer.parseInt(id));
		if(person == null) {
			System.out.println("customerID does not exist");
			return;
		}
		List<Account> list = employeeService.seeAccounts(Integer.parseInt(id));
		System.out.print(person);
		for(Account a: list) {
			System.out.println(a);
		}
	}
	
	/**
	 * Sees pending applications
	 */
	public void seePending() {
		System.out.println("Here are the pending applications");
		List<Account> list = employeeService.seeAllAccounts();
		
		for(Account a: list) {
			if(a.getStatus().equals("pending")) {
				System.out.println(a);
			}	
		}
		
			
	}
	
	/**
	 * Decides to move forward on application
	 */
	public void decide() {
		System.out.println("1. To process an application\n"
				+ "2. Go back to employee menu");
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
	 * approves or denies an account
	 * @param id
	 * @param answer
	 */
	public void approveOrDeny(int id, String answer) {	
		
		if(answer.equals("approve") || answer.equals("deny")) {
			employeeService.processed(id, answer);
			
		} else {
			System.out.println("Sorry wrong input");
		}
	}
	
}
