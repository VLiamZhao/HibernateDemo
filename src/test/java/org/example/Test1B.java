package org.example;

import org.example.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1B {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session1 = factory.openSession();
        User user1 = (User) session1.load(User.class, "Bob");
        System.out.println(user1);
        session1.close();

        Session session2 = factory.openSession();

        User user2 = (User) session2.load(User.class, "HBob");
        System.out.println(user2);
        session2.close();
        try {
            Thread.sleep(6000); // second level cache only last for 5 sec
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session session3 = factory.openSession();
        User user3 = (User) session3.load(User.class, "HBob");
        System.out.println(user3);
        System.out.println("user2 == user3? " + (user2 == user3));
        System.out.println(user2.getName() == user3.getName());
        session3.close();
     }
}
