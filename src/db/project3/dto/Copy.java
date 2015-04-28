package db.project3.dto;

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
	private CheckoutStatus CheckOutStatus = CheckoutStatus.OnShelf;
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
		return CheckOutStatus;
	}
	public void setCheckOutStatus(CheckoutStatus checkOutStatus) {
		CheckOutStatus = checkOutStatus;
	}
	
	
}
