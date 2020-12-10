package org.example;

import org.example.beans.User;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test1A {
    public static void main(String[] agrs) {
        Session session = HibernateUtil.currentSession();
        User user = (User) session.load(User.class, "KK");
        System.out.println(user);
        HibernateUtil.closeSession();
        user.setAge(18);

        Session session2 = HibernateUtil.currentSession();
        session2.merge(user);
        user = (User) session2.load(User.class, "KK");
        System.out.println(user);
        Transaction tx = session2.beginTransaction();
        tx.commit();
        HibernateUtil.closeSession();;
    }
}
