package db.project3.dto;

import javax.persistence.Entity;

@Entity
public class Publisher {
	
	private int id;
	private String publisher;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisherCompany() {
		return publisher;
	}
	public void setPublisherCompany(String publisherCompany) {
		this.publisher = publisherCompany;
	}	
}
