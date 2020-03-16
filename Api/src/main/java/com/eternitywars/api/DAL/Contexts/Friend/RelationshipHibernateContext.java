package com.eternitywars.api.DAL.Contexts.Friend;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Friend.IRelationshipContext;
import com.eternitywars.api.Models.Entities.Relationship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RelationshipHibernateContext implements IRelationshipContext
{
    private static SessionFactory sessionFactory = ApiApplication.getSessionFactory();

    private Session session;
    private Transaction transaction;

    @Override
    public boolean UpdateRelationship(Relationship relationship)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(relationship);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return true;
    }
}
