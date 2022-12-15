package com.groupeisi.repository;

import com.groupeisi.entities.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoleImpl implements IRole {

    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = null;

    @Override
    public int add(Role role) {

        try {
            transaction = session.beginTransaction();

            session.persist(role);

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
