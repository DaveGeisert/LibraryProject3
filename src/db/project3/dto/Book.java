package db.project3.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {
	
	@Id
	private String isbn;
	private String title;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Author author;
	
	@Embedded
	private Subject subject;

	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Copy> Copies = new ArrayList<Copy>();
	
	
	
	public Collection<Copy> getCopies() {
		return Copies;
	}
	public void setCopies(Collection<Copy> copies) {
		Copies = copies;
	}

	public Subject getSubject(){
		return subject;
	}
	
	public void setSubject(Subject subject){
		this.subject = subject;
	}


	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
