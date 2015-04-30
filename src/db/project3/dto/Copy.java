package db.project3.dto;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Book_Copy")
public class Copy {
	@Id@GeneratedValue
	private int BId;
	
	@ManyToOne
	private Book book;
	//after adding user DTO, Don't define. Make return based on if checkout/user exists
	private CheckoutStatus checkOutStatus;
	private User checkedOutBy = null;
	@ManyToOne
	private Date checkOutDate;
	private Date dueDate;
	
		
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
	public void setCheckedOutBy(User checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
		this.checkOutDate = new Date(Calendar.getInstance().getTimeInMillis());
		//set due date
		checkOutStatus = CheckoutStatus.CheckedOut;	
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
