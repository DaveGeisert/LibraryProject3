package db.project3.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import db.project3.connections.Connection;
import db.project3.dto.CheckoutStatus;
import db.project3.dto.Copy;

public class ReturnAllBooks {

	@Test
	public void test() {
		Session session = Connection.openSession();
		Query q = session.createQuery("From Copy where CheckoutStatus = ?");
		q.setInteger(0, CheckoutStatus.CheckedOut.ordinal());
		
		session.beginTransaction();
		List<Copy> copies = (List<Copy>) q.list();
		for(Copy copy : copies){
			copy.setBorrowedBy(null);
			copy.setCheckedOutBy(null);
			copy.setDueDate(null);
			copy.setCheckOutDate(null);
			copy.setCheckOutStatus(CheckoutStatus.OnShelf);
			session.update(copy);
		}
		session.getTransaction().commit();
		session.close();
	}

}
