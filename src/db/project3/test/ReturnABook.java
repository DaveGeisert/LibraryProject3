package db.project3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import db.project3.core.ReturnBook;

public class ReturnABook {

	@Test
	public void test() {
		ReturnBook rBook = new ReturnBook();
		try {
			rBook.returnBook("johnoliver", "A Song of Ice and Fire: A Clash of Kings");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
