package controller;

import java.util.Scanner;

import dao.searchCar;



public class mainClass {
	
	public static void menuWhlie() {
		DB_Connection db = new DB_Connection();
		int choice = 0;

		Scanner sc = new Scanner(System.in);
		while (true) {
			menuClass.menu();
			choice = sc.nextInt();
			if (choice == 1) {
				userClass.userMenu();
				choice = sc.nextInt();
				if (choice == 1) {
					searchCar.searchType();
				} else if (choice == 2) {
					
				} else if (choice == 3) {
					mainClass.menuWhlie();
				}
			} else if (choice == 2) {
			} else if (choice == 3) {
			} else if (choice == 4) {
			}
		}
	}
	
	public static void main(String[] args) {
		mainClass.menuWhlie();
	}
}
