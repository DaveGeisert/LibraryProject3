package db.project3.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Borrower")
public class Borrower extends User{
	
	private Date joinDate;
	@OneToMany
	private Collection<Copy> borrowedBooks = new ArrayList<Copy>();
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Collection<Copy> getBorrowedBooks() {
		return borrowedBooks;
	}	
}
