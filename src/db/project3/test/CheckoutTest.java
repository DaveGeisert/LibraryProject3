package db.project3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import db.project3.core.Checkout;

public class CheckoutTest {

	@Test
	public void test() {
		Checkout checkout = new Checkout();
		
		try {
			checkout.checkout("michaelscott", "johnoliver", "A Song of Ice and Fire: A Clash of Kings");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
