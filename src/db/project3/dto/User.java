package db.project3.dto;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id @GeneratedValue
	private int LibraryCardNumber;
	private String FirstName;
	private String LastName;
	
	@Embedded
	private Address address;
	private Date joinDate;
	public int getLibraryCardNumber() {
		return LibraryCardNumber;
	}
	public void setLibraryCardNumber(int libraryCardNumber) {
		LibraryCardNumber = libraryCardNumber;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
