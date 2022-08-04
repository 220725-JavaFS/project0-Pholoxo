package com.revature.controllers;

import java.util.Scanner;
import com.revature.models.Customer;

public class RegisterController {
	
	private Scanner scan = new Scanner(System.in);
	
	
	public RegisterController() {
		
	}
	
	public void register() {
		System.out.println("Enter your full name");
		
		String name = scan.nextLine();
		
		System.out.println("Enter your would be password");
		
		String pass = scan.nextLine();
		
		System.out.println("Enter your would be username");
		
		String user = scan.nextLine();
		
		System.out.println("Choose which account to choose from: Checking, Savings, Investment."
				+ " Please enter exactly the type of account that is shown on this sentence.");
		String account = scan.nextLine();
		
		if(account.toLowerCase().trim().equals("Investment")) {
			System.out.println("This will be on review");
		}
		
	}
}
