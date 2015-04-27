package db.project3.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {
	
	@Id
	private String isbn;
	private String title;
	
	@ManyToOne
	private Author author;
	
	@Embedded
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns = { @Column(name="SUBJECT_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Subject> subject = new ArrayList<Subject>();
	
	public Collection<Subject> getSubject() {
		return subject;
	}
	public void setSubject(Collection<Subject> subject) {
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
