package org.example;

import org.example.beans.User;
import org.example.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        User user = new User("KK", 23); //transient
        session.save(user); //persistent
        tx.commit();
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> list = query.list();
        for (User u : list) {
            System.out.println(u);
        }
        HibernateUtil.closeSession(); //detached
    }
}
