package db.project3.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import db.project3.connections.Connection;
import db.project3.dto.Staff;
import db.project3.dto.User;

public class TestStaffRetrieval {

	@Test
	public void test() {
		Session session = Connection.openSession();
		Query query = session.createQuery("From User where AccountType = ? and userName = ?");
		query.setString(0, "Borrower");
		query.setString(1, "michaelscott");
		List<User> staffUsers = (List<User>) query.list();
		Staff staff = (Staff) staffUsers.get(0);
		
		System.out.println(staff.getUserName());
	}

}
