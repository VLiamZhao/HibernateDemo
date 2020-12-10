package org.example;

import org.example.beans.User;
import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Test1C {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        String hql = "from User";
        Query query = session.createQuery(hql);
        query.setCacheable(true); // if we do not use this line, there will be two queries, but will be one query if we use this line.
        List<User> list = query.list();
        for (User u : list) {
            System.out.println(u);
        }
        List<User> list2 = query.list();
        for (User u : list2) {
            System.out.println(u);
        }
        HibernateUtil.closeSession();
    }
}
