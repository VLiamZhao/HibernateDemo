package org.example;

import org.example.beans.User;
import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Query query = session.getNamedQuery("userQuery");
        query.setInteger("age", 20);
        List<User> list = query.list();
        for (User u : list) {
            System.out.println(u);
        }

        String sql = "select * from sample where name=:name";
        query = session.createSQLQuery(sql).addEntity(User.class);
        query.setString("name", "HBob");
        User user = (User) query.uniqueResult();
        System.out.println(user);
        HibernateUtil.closeSession();
    }
}
