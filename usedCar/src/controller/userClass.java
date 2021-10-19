package controller;

import java.util.Scanner;

public class userClass {
	public static void userMenu() {
		System.out.println("1. 차량검색");
		System.out.println("2. 차량구매");
		System.out.println("3. 뒤로가기");
	}
	
	public static void main(String[] args) {
		int choice = 0;

		Scanner sc = new Scanner(System.in);
		while (true) {
			userClass.userMenu();
			choice = sc.nextInt();
			if (choice == 1) {
			} else if (choice == 2) {
			} else if (choice == 3) {
			} else if (choice == 4) {
			}
		}
	}
}
