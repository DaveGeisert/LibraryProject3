package db.project3.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.project3.dto.Address;
import db.project3.dto.User;

public class UserTest {

	public static void main(String[] args) {
		
		User user = new User();
		user.setUserName("JohnLennon");
		user.setFirstName("John");
		user.setLastName("Lennon");
		
		User user2 = new User();
		user2.setUserName("BillLumberg");
		user2.setFirstName("Bill");
		user2.setLastName("Lumberg");
		
		Address address1 = new Address();
		address1.setStreetAddress("Street");
		address1.setCity("Seattle");
		address1.setState("WA");
		address1.setZipCode(45698);
		user.setAddress(address1);

		Address address2 = new Address();
		address2.setStreetAddress("Street2");
		address2.setCity("Seattle");
		address2.setState("WA");
		address2.setZipCode(45698);
		user2.setAddress(address2);
		
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
	}

}
