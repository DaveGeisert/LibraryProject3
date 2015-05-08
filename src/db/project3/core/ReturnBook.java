package db.project3.core;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import db.project3.connections.Connection;
import db.project3.dto.Book;
import db.project3.dto.Borrower;
import db.project3.dto.CheckoutStatus;
import db.project3.dto.Copy;

public class ReturnBook {
	
	public void returnBook (String borrowerName, String bookTitle) throws Exception{
		
		Boolean returnReady = false;
		Session session = Connection.openSession();
		Query userQuery = session.createQuery("From User Where AccountType = ? and userName = ?");
		userQuery.setString(0, "Borrower");
		userQuery.setString(1, borrowerName);
		List<Borrower> borrowers = (List<Borrower>) userQuery.list();
		if(borrowers.isEmpty()){
			throw new Exception("The User " + borrowerName + "Could Not Be Found!");
		}
		
		Borrower borrower = borrowers.get(0);
		Copy copy = null;
		for(Copy iCopy : borrower.getBorrowedBooks()){
			if(iCopy.getBook().getTitle().equalsIgnoreCase(bookTitle)){
				copy = iCopy;
				returnReady = true;
				break;
			}
		}
		if(!returnReady){
			throw new Exception("There was an error returning your book ");
		}
		borrower.getBorrowedBooks().remove(copy);
		clearCheckout(copy);
		session.beginTransaction();
		session.update(copy);
		session.getTransaction().commit();
		session.close();
	}
	
	public void clearCheckout(Copy copy){
		copy.setBorrowedBy(null);
		copy.setCheckedOutBy(null);
		copy.setDueDate(null);
		copy.setCheckOutDate(null);
		copy.setCheckOutStatus(CheckoutStatus.OnShelf);
	}
}
