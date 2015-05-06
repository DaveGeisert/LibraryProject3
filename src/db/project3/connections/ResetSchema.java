package db.project3.connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class ResetSchema {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	private static boolean initialized;
	
	private ResetSchema(){
		initialized = false;
	}
	
	private static void initialize(){
		configuration = new Configuration();
		configuration.configure("hibernateReset.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static Session openSession(){
		if (!initialized){
			initialize();
			initialized = true;
		}
		return sessionFactory.openSession();
	}
}
