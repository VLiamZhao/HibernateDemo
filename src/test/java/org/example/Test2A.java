package org.example;

import org.example.beans.User;
import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Test2A {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Query query = session.getNamedQuery("userSP");
        List<User> list = query.list();
        for(User u : list) {
            System.out.println(u);
        }
        System.out.println("*************************");
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sp = "{call queryuser()}";
                CallableStatement cs = connection.prepareCall(sp);
                cs.execute();
            }
        });
    }
}
