package db.project3.connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class Connection {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	private static boolean initialized;
	
	private Connection(){
		initialized = false;
	}
	
	private static void initialize(){
		configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static Session openSession(){
		if (!initialized){
			initialize();
		}
		return sessionFactory.openSession();
	}
}
