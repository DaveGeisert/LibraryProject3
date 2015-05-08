package ui;

import java.util.Scanner;

import db.project3.core.CheckoutBook;

public class CheckoutUI {

	public static void main(String[] args) {
		try{
			Scanner in = new Scanner(System.in);
			System.out.println("Checkout Interface");
			System.out.println("Enter a staff username");
			
			String staffName = in.nextLine();
			
			System.out.println("Enter a borrower username");
			String uName = in.nextLine();
			
			System.out.println("Enter the title of the book you wish to checkout");
			String bName = in.nextLine();
			
			CheckoutBook checkout = new CheckoutBook();
			checkout.checkout(staffName, uName, bName);
			in.close();
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
