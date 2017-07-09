package com.canh.healthcare.jpa.utils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            
            Configuration configuration = new Configuration();
            configuration.configure();
            //set path of config file explicitly
            //configuration.configure("/src/main/resources/hibernate.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration
                    .buildSessionFactory(serviceRegistry);
            return sessionFactory;
            
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}
