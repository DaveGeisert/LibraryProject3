package db.project3.core;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import db.project3.connections.Connection;
import db.project3.dto.Book;
import db.project3.dto.Borrower;
import db.project3.dto.CheckoutStatus;
import db.project3.dto.Copy;
import db.project3.dto.Staff;
import db.project3.dto.User;

public class CheckoutBook {
	
	
	public void checkout(String staffUname, String borrowerUname, String bookTitle) throws Exception{
		boolean checkoutSuccessful = false;
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
		if (borrower.getBorrowedBooks().size() >= 3){
			throw new Exception("Cannot checkout more books! Maximum allowance is 3");
		}
		
		Query bookQuery = session.createQuery("From Book where Title = ?");
		bookQuery.setString(0, bookTitle);
		
		List<Book> books = (List<Book>) bookQuery.list();
		if(books.isEmpty()){
			throw new Exception("Book " + bookTitle + " is not available for checkout");
		}
		Book book = books.get(0);
		
		for(Copy iCopy : book.getCopies()){
			if (iCopy.getCheckOutStatus() == CheckoutStatus.OnShelf){
				cacheCheckout(iCopy, staff, borrower);
				session.beginTransaction();
				session.update(iCopy);
				session.getTransaction().commit();
				session.close();
				checkoutSuccessful = true;
				break;
			}
		}
		if (!checkoutSuccessful){
			throw new Exception("There are no copies of " + bookTitle + " available for chekcout");
		}
		
	}
	
	private void cacheCheckout(Copy copy, Staff staff, Borrower borrower){
		Calendar cal = Calendar.getInstance();
		java.util.Date now = cal.getTime();
		cal.add(Calendar.DATE, 14);
		
		
		Date today = new Date(now.getTime());
		Date dueDate = new Date(cal.getTime().getTime());
		copy.setCheckedOutBy(staff);
		copy.setBorrowedBy(borrower);
		copy.setCheckOutDate(today);
		copy.setDueDate(dueDate);
		copy.setCheckOutStatus(CheckoutStatus.CheckedOut);
		borrower.getBorrowedBooks().add(copy);
	}

}
