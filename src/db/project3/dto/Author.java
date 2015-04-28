package db.project3.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Author {
	
	@Id @GeneratedValue
	private int id;
	private String FirstName;
	private String LastName;
	@OneToMany
	private Collection<Book> booksWritten = new ArrayList<Book>();
	
	
	public Collection<Book> getBooksWritten() {
		return booksWritten;
	}
	public void setBooksWritten(Collection<Book> booksWritten) {
		this.booksWritten = booksWritten;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}	
}
