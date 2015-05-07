package db.project3.core;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import db.project3.connections.Connection;
import db.project3.dto.Book;
import db.project3.dto.Borrower;
import db.project3.dto.Staff;
import db.project3.dto.User;

public class Checkout {
	
	
	public void checkout(String staffUname, String borrowerUname, String bookTitle) throws Exception{
		Session session = Connection.openSession();
		Query userQuery = session.createQuery("From User where AccountType = ? and userName = ?");
		userQuery.setString(0, "Staff");
		userQuery.setString(1, staffUname);
		List<User> staffUsers = (List<User>) userQuery.list();
		
		if (staffUsers.isEmpty())
			throw new Exception("Staff User " + staffUname + " Not Found");
		Staff staff = (Staff) staffUsers.get(0);
		userQuery.setString(0, "Borrower");
		userQuery.setString(1, borrowerUname);
		
		List<User> borrowerUsers = (List<User>) userQuery.list();
		if(borrowerUsers.isEmpty())
			throw new Exception("Borrower User " + borrowerUname + " Not Found");
		Borrower borrower = (Borrower) borrowerUsers.get(0);
		
		Query bookQuery = session.createQuery("From Book where Title = ?");
		bookQuery.setString(0, bookTitle);
		
		List<Book> books = (List<Book>) bookQuery.list();
		if(books.isEmpty()){
			throw new Exception("Book " + bookTitle + " is not available for checkout");
		}
		
		
	}

}
