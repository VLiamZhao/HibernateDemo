package org.example;

import org.example.beans.User;
import org.example.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Test2D {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();

        String hql = "Update User set age=:age where name=:name";
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setString("name", "Alice");
        query.setInteger("age", 25);
        query.executeUpdate();
        tx.commit();

        tx = session.beginTransaction();
        User user = (User) session.load(User.class, "Tommy");
        user.setAge(50);
        tx.commit();

        Criteria ct = session.createCriteria(User.class);
        tx = session.beginTransaction();
        User user2 = (User) ct.add(Restrictions.eq("name", "Tom")).uniqueResult();
        user2.setAge(70);
        tx.commit();
        session.close();
    }
}
