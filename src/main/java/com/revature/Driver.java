package com.revature;

import com.revature.controllers.MenuController;


public class Driver {
	
	/**
	 * This is the driver to start the program
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to Krusty Krab Banking!");
		
		MenuController menu = new MenuController();
		
		menu.mainMenu();
		
		System.out.println("Goodbye!");		    
		        	
	}

}
