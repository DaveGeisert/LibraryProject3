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
	private CheckoutStatus checkOutStatus;
	@ManyToOne
	private Borrower checkedOutBy = null;
	@ManyToOne
	private Staff loanedBy = null;
	private Date checkOutDate;
	private Date dueDate;	
		
	public Staff getLoanedBy() {
		return loanedBy;
	}
	public void setLoanedBy(Staff loanedBy) {
		this.loanedBy = loanedBy;
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
	public User getCheckedOutBy() {
		return checkedOutBy;
	}
	public void setCheckedOutBy(Borrower checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}
	public int getBId() {
		return BId;
	}
	public void setBId(int bId) {
		BId = bId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public CheckoutStatus getCheckOutStatus() {
		return checkOutStatus;
	}
	public void setCheckOutStatus(CheckoutStatus checkOutStatus) {
		this.checkOutStatus = checkOutStatus;
	}	
}
