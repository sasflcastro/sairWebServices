package ec.com.rgt.sair.dao;

import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
//import org.hibernate.Session;

public class HibernateUtiles {

	public static final SessionFactory sessionFactory;
   // public static final SessionFactory serialSessionFactory;
   // public static final SessionFactory singleton;
    static { 
        try {
            
            Configuration classicConf = new Configuration().configure();
            sessionFactory = classicConf.buildSessionFactory();
                    
            /*Configuration serialConf = new Configuration().configure();
            serialConf.setProperty("hibernate.connection.isolation",String.valueOf(java.sql.Connection.TRANSACTION_SERIALIZABLE));
            serialSessionFactory = serialConf.buildSessionFactory();*/
            
            //singleton=new AnnotationConfiguration().configure().buildSessionFactory();
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //public static final ThreadLocal session = new ThreadLocal();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /*public static SessionFactory getSerialSessionFactory(){
        return serialSessionFactory;
    }
    
    public static SessionFactory getSingleton(){
        return singleton;
    }
    */
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}
