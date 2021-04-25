package de.pater.datawarehouse.app;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryHelper {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();
            sessionFactory = config.configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Error in creating SessionFactory object."
                    + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) {
        Session session = SessionFactoryHelper.getSessionFactory()
            .getCurrentSession();

        System.out.println("session = " + session);
    }



    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}