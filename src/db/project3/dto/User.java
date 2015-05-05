package db.project3.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="AccountType", discriminatorType=DiscriminatorType.STRING)
public class User {
	
	@Id @GeneratedValue
	private int LibraryCardNumber;
	@Column(unique=true, nullable=false)
	private String userName;	
	@Column(nullable=false)
	private String Password;
	@Column(nullable=false)
	private String FirstName;
	@Column(nullable=false)
	private String LastName;	
	@Embedded
	private Address address;
	
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
}
