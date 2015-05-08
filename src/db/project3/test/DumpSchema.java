package db.project3.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import db.project3.connections.ResetSchema;

public class DumpSchema {

	@Test
	public void test() {
		Session session = ResetSchema.openSession();
		session.close();
	}

}
