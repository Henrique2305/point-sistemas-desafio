package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

//    public static SessionFactory buildSessionFactory()  {
//        return new Configuration().configure().buildSessionFactory();
//    }

//    @SuppressWarnings("deprecation")
    public static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError("BD connection failed" + ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
