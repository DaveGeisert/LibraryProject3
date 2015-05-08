package db.project3.core;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import db.project3.connections.Connection;
import db.project3.dto.Borrower;
import db.project3.dto.Copy;

public class SearchUser {

	public List<Copy> getBooksCheckedOut(String userName)throws Exception{
		Session session = Connection.openSession();
		Query userQ = session.createQuery("From User where AccountType = ? And userName = ?");
		userQ.setString(0, "Borrower");
		userQ.setString(1, userName);
		
		List<Borrower> borrowers = (List<Borrower>) userQ.list();
		if(borrowers.isEmpty()){
			throw new Exception("the user " + userName + "could not be found");
		}
		return (List<Copy>) borrowers.get(0).getBorrowedBooks();
	}
}
