package com.example.hiber_vol;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import  java.util.Date;
import java.time.LocalDate;


public class App {
    public static void main(String[] args) {
       /* System.out.println("hey main");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        SessionFactory factory = new Configuration().configure("hibernate.xml").buildSessionFactory();
        System.out.println(factory);*/

        SessionFactory factory=   HibernateUtil.getSessionFactory();

siege s = new siege();
s.setIds(1);
s.setNums(100);

          s.setEtat(true);
        s.setId_vol(1);



        Session session=factory.openSession();

        Transaction tx=session.beginTransaction();

        session.save(s);
        System.out.println(factory);
        tx.commit();
        session.close();
    }
}