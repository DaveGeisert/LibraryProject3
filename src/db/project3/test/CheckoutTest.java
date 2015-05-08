package db.project3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import db.project3.core.CheckoutBook;

public class CheckoutTest {

	@Test
	public void test() {
		CheckoutBook checkout = new CheckoutBook();
		
		try {
			checkout.checkout("michaelscott", "johnoliver", "A Song of Ice and Fire: A Clash of Kings");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
