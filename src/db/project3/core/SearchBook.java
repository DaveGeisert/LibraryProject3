package db.project3.core;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import db.project3.connections.Connection;
import db.project3.dto.Author;
import db.project3.dto.Book;

public class SearchBook {

	public List<Book> ByTitle(String titleQ)throws Exception{
		Session session = Connection.openSession();
		Query query = session.createQuery("From Book where title = ?");
		query.setString(0, titleQ);
		List<Book> results = (List<Book>) query.list();
		if(results.isEmpty()){
			throw new Exception("Book not found ");
		}
		session.close();
		return results;		
	}
	
	public List<Book> ByAuthor(String firstName, String lastName)throws Exception{
		Session session = Connection.openSession();
		Query query = session.createQuery("From Author where firstName = ? and lastName = ?");
		query.setString(0, firstName);
		query.setString(1, lastName);
		List<Author> results = (List<Author>) query.list();
		if(results.isEmpty()){
			throw new Exception("Author not found ");
		}
		
		return (List<Book>) results.get(0).getBooksWritten();
	}
	
	public List<Book> BySubject(String subjectQ)throws Exception{
		Session session = Connection.openSession();
		Query query = session.createQuery("From Book where subject = ?");
		query.setString(0, subjectQ);
		List<Book> results = (List<Book>) query.list();
		if(results.isEmpty()){
			throw new Exception("Book not found ");
		}
		session.close();
		return results;
	}
	
	public List<Book> ByIsbn(int isbnQ)throws Exception{
		Session session = Connection.openSession();
		Query query = session.createQuery("From Book where title = ?");
		query.setInteger(0, isbnQ);
		List<Book> results = (List<Book>) query.list();
		if(results.isEmpty()){
			throw new Exception("Book not found ");
		}
		session.close();
		return results;
	}
}
