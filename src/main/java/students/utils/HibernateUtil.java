package students.utils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static StandardServiceRegistry serviceRegistry;
	private static final SessionFactory sessionFactory;
	
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		return configuration.buildSessionFactory(new ServiceRegistryBuilder() 
		                  .applySettings(configuration.getProperties())
		                  .buildServiceRegistry());
	}

}