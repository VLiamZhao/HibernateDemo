package org.example;

import org.example.beans.User;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class Test2B {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        User user1 = (User) session.load(User.class, "HBob");
        System.out.println(user1.getClass().getName());
        System.out.println(user1 == null);
        System.out.println(user1);
        System.out.println(user1.getClass().getName());

        System.out.println("********************");

        User user2 = (User) session.get(User.class, "KK");
        System.out.println(user2.getClass().getName());
        System.out.println(user2 == null);
        System.out.println(user2);
        System.out.println(user2.getClass().getName());
    }
}
