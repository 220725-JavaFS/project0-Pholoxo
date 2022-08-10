package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.RegisterService;


public class RegisterController {
	
	private Scanner scan = new Scanner(System.in);
	private RegisterService register = new RegisterService();
	private MenuController menu = new MenuController();
	
	/**
	 * This is an empty constructor
	 */
	public RegisterController() {
		// Empty Constructor
	}
	
	public void register() {
		System.out.println("Enter your full name");
		
		String name = scan.nextLine();
		
		System.out.println("Enter your would be password");
		
		String pass = scan.nextLine();
		
		System.out.println("Enter your would be username");
		
		String user = scan.nextLine();
		
		
		
		if(ifExists(user)) {
			System.out.println("Sorry this person with this username: "
					+ user + " already exists");
			
		} else {
			register.addCustomer(name, pass, user);
			System.out.println("Congratulations on registering! You will be rerouted to the main menu.");
		}
		
		
		menu.mainMenu();
		
		
	}
	
	public boolean ifExists(String username) {
		return register.ifExists(username);
	}
}
