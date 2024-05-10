package com.example.hiber_vol;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Environment;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    private  static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){

            Configuration configuration= new  Configuration();
            Properties properties= new Properties();
            properties.put(Environment.DRIVER,"org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/vols");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "1234");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.SHOW_SQL,true);

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(siege.class);
            StandardServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return  sessionFactory;
    }
}
