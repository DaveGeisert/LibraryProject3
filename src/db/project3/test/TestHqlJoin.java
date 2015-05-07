package db.project3.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import db.project3.connections.Connection;
import db.project3.dto.Book;
import db.project3.dto.CheckoutStatus;

public class TestHqlJoin {

	private List books;

	@Test
	public void test() {
		Session session = Connection.openSession();
		Query bookQuery = session.createQuery("From Book as book INNER JOIN book.copies as bc where isbn = ? and bc.checkOutStatus = ?");
		bookQuery.setInteger(0, 1000000);
		bookQuery.setInteger(1, CheckoutStatus.OnShelf.ordinal());
		books = bookQuery.list();
		books.clear();
	}

}
