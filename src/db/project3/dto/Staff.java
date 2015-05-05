package db.project3.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Staff")
public class Staff extends User{

	private Date hireDate;
	
	@OneToMany
	private Collection<Copy> LoanedBooks = new ArrayList<Copy>();
	
	public Collection<Copy> getLoanedBooks() {
		return LoanedBooks;
	}

	public void setLoanedBooks(Collection<Copy> loanedBooks) {
		LoanedBooks = loanedBooks;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
}
