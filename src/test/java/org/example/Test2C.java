package org.example;

import org.example.beans.User;
import org.example.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class Test2C {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Criteria ct = session.createCriteria(User.class);
        User user = (User) ct.add(Restrictions.eq("name", "HBob"))
                .add(Restrictions.gt("age", 10))
                .uniqueResult();
        System.out.println(user);
        HibernateUtil.closeSession();
    }
}
