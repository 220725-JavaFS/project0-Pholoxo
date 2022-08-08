package com.revature;

import com.revature.controllers.MenuController;


public class Driver {
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Ohara Banking!");
		
		MenuController menu = new MenuController();
		
		menu.mainMenu();
		
		System.out.println("Goodbye!");		    
		        	
	}

}
