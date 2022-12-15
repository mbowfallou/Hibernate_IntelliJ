package com.groupeisi.repository;

import com.groupeisi.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserImpl implements IUser {

    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = null;

    @Override
    public int add(User user) {

        try {
            transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();

            return 1;
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();

            return 0;
        }

    }
}
