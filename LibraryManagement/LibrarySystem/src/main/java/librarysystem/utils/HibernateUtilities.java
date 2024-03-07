package librarysystem.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {

    public static Session getCurrentSessionFromConfiguration() {
        Configuration configuration = new Configuration();

        Session session;

        try (SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory()) {

            session = factory.getCurrentSession();
        }

        return session;
    }
}
