package belajar_java_hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static final ThreadLocal session = new ThreadLocal();
    
    public static Session currentSession()throws HibernateException {
        Session sess = (Session) session.get();
        if(sess == null) {
            sess = sessionFactory.openSession();
        }
        return sess;
    } 
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void SessionClose()throws Exception {
        Session s = (Session) session.get();
        if(s != null)
            s.close();
        session.set(null);
    }
}
