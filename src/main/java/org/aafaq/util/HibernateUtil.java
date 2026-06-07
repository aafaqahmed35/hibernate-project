package org.aafaq.util;

import org.aafaq.entity.largeObjectDemo;
import org.aafaq.entity.Workers;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory factory =
            new Configuration()
                    .configure()
                    .addAnnotatedClass(Workers.class)
                    .addAnnotatedClass(largeObjectDemo.class)
                    .buildSessionFactory();

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void shutdown() {
        factory.close();
    }
}