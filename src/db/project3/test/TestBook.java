package db.project3.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.project3.connections.Connection;
import db.project3.dto.*;

/*
 * This Class will test to make sure hibernate can connect with your database.
 * If This works, the library database should have a table named "book"
 * with a book titled "Adventures of Huckleberry Finn"
 */

public class TestBook {
	
	public static void main(String args[]){
						
		Book book = new Book();
		book.setIsbn("123456abcd");
		book.setTitle("Adventures of Huckleberry Finn");
		
		Copy bookCopy = new Copy();
		bookCopy.setBook(book);
		book.getCopies().add(bookCopy);
		
		Book book1 = new Book();
		book1.setIsbn("abc");
		book1.setTitle("some other Twain Novel");
		
		Copy book1Copy = new Copy();
		book1Copy.setBook(book1);
		book1.getCopies().add(book1Copy);
		
		Author author1 = new Author();
		author1.setFirstName("Mark");
		author1.setLastName("Twain");
		
		Subject subject1 = new Subject();
		subject1.setSubjectDesc("Fiction");
		
		book.setAuthor(author1);
		book.setSubject(subject1);
		book1.setAuthor(author1);
		book1.setSubject(subject1);
		author1.getBooksWritten().add(book);
		author1.getBooksWritten().add(book1);
				
		Session session = Connection.openSession();
		
		session.beginTransaction();
		session.save(book);
		session.save(book1);
		session.getTransaction().commit();
		session.close();
		
	}

}
