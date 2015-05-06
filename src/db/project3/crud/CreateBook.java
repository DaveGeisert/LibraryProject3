package db.project3.crud;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import db.project3.connections.Connection;
import db.project3.dto.Author;
import db.project3.dto.Book;
import db.project3.dto.Copy;

public class CreateBook {
	
	public void createBook(Book book){
		
	}
	
	public void createBook(String isbn, String title, String subject, String AuthorFirstName, String AuthorLastName){
		Session session = Connection.openSession();
		session.beginTransaction();
		Query queryisbn = session.getNamedQuery("Book.byISBN");
		queryisbn.setString(0, isbn);
		
		Query queryauthor = session.getNamedQuery("Author.byFirstAndLast");
		queryauthor.setString(0, AuthorFirstName);
		queryauthor.setString(1, AuthorLastName);
		
		List<Book> books = (List<Book>) queryisbn.list();
		List<Author> authors = (List<Author>) queryauthor.list();
		Book book;
		if (books.isEmpty()){
			book = new Book();
			book.setIsbn(isbn);
			book.setTitle(title);
			book.setSubject(subject);
			Author author;
			if(authors.isEmpty()){
				author = new Author();
				author.setFirstName(AuthorFirstName);
				author.setLastName(AuthorLastName);
				
			}else{
				author = authors.get(0);
			}
			book.setAuthor(author);
			author.getBooksWritten().add(book);
			Copy copy = new Copy();
			copy.setBook(book);
			book.getCopies().add(copy);
			session.save(book);
		}else{
			book = books.get(0);
			Copy copy = new Copy();
			copy.setBook(book);
			book.getCopies().add(copy);
			session.update(book);
		}		
		session.getTransaction().commit();
		session.close();
	}

	public void createBooks(Collection<Book> Books){
		
	}
}
