package db.project3.dto;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="copyofbook")
public class Copy {
	@Id@GeneratedValue@Column(name="BookId")
	private int BId;
	
	@ManyToOne
	private Book book;
	private CheckoutStatus checkOutStatus = CheckoutStatus.OnShelf;
	@ManyToOne
	private Borrower borrowedBy = null;
	@ManyToOne
	private Staff checkedOutBy = null;
	private Date checkOutDate;
	private Date dueDate;	
		
	public Staff getCheckedOutBy() {
		return checkedOutBy;
	}
	public void setCheckedOutBy(Staff loanedBy) {
		this.checkedOutBy = loanedBy;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Borrower getBorrowedBy() {
		return borrowedBy;
	}
	public void setBorrowedBy(Borrower checkedOutBy) {
		this.borrowedBy = checkedOutBy;
	}
	public int getBId() {
		return BId;
	}
	public Book getBook() {
		return book;
	}
	public CheckoutStatus getCheckOutStatus() {
		return checkOutStatus;
	}
	public void setCheckOutStatus(CheckoutStatus checkOutStatus) {
		this.checkOutStatus = checkOutStatus;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
