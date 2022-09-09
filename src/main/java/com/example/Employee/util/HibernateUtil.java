package com.example.Employee.util;

import com.example.Employee.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static Session getCurrentSessionFromConfig() {
        // SessionFactory in Hibernate 5 example
        Configuration config = new Configuration()
                .addAnnotatedClass(Employee.class);
        config.configure("hibernate.cfg.xml");
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
