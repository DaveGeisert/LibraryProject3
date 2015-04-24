package db.project3.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.project3.dto.Book;

/*
 * This Class will test to make sure hibernate can connect with your database.
 * If This works, the library database should have a table named "book"
 * with a book titled "Adventures of Huckleberry Finn"
 */

public class TestBook {
	
	public static void main(String args[]){
		
		//create a new "book" entity and populate the data		
		Book book = new Book();
		book.setId(1);
		book.setIsbn("123456abcd");
		book.setTitle("Adventures of Huckleberry Finn");
		book.setAuthor("Mark Twain");
		
		//Build the Hibernate config and the session factory 
		//this is all straight from google, don't let it intimidate you		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//Open a session connection to the database
		Session session = sessionFactory.openSession();
		
		//Start a database transaction and save the data to the database
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		
	}

}
