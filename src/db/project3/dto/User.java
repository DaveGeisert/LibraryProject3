package db.project3.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
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
	@Column(nullable=false)
	private AccountType accountType;
	@Embedded
	private Address address;
	private Date joinDate;
	
	
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
