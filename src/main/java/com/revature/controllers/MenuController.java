package com.revature.controllers;
import java.util.Scanner;


public class MenuController {
	private Scanner scan = new Scanner(System.in);
	
	public void mainMenu() {
		String choice = "";
		
		while(!choice.equals("3")) {
			System.out.println("What do you want to do at the bank?"
						
					         + "\n 1. To login your account"
							 + "\n 2. To register a new account"
					         + "\n 3. To quit");
			choice = scan.nextLine();
			switch(choice) {
			case "1":
				System.out.println("What is your role?"
								  + "\n 1. Customer"
								  + "\n 2. Employee"
								  + "\n 3. Admin");
				 
				String role = scan.nextLine();
				switch(role) {
					case "1":
						CustomerController customer = new CustomerController();
						customer.customerMenu();
						break;
					case "2":
						EmployeeController employee = new EmployeeController();
						employee.employeeMenu();
						break;
					case "3":
						AdminController admin = new AdminController();
						admin.adminMenu();
						break;
					default:
						System.out.println("Sorry that is not a valid input please try again. ");
						break;
					}
					
					break;
			case "2":
				RegisterController reg = new RegisterController();
				reg.register();
				break;
			case "3":
				break;
			}
		}
	}
}
