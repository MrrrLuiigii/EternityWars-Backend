package com.eternitywars.api.DAL.Contexts.Friend;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Friend.IRelationshipContainerContext;
import com.eternitywars.api.Models.Entities.CardCollection;
import com.eternitywars.api.Models.Entities.Relationship;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Relationships;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class RelationshipContainerHibernateContext implements IRelationshipContainerContext
{
    private static SessionFactory sessionFactory = ApiApplication.getSessionFactory();

    private Session session;
    private Transaction transaction;

    @Override
    public boolean AddRelationship(Relationship relationship)
    {
        boolean status = true;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(relationship);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
                status = false;

            }

            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return status;
    }

    @Override
    public boolean DeleteRelationship(Relationship relationship)
    {
        String hql = "SELECT r FROM Relationship r " +
                "WHERE (r.friendOne = :friendOne AND r.friendTwo = :friendTwo) " +
                "OR (r.friendOne = :friendTwo AND r.friendTwo = :friendOne)";


        boolean status = true;

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<Relationship> typedQuery = session.createQuery(hql, Relationship.class);
            typedQuery.setParameter("friendOne", relationship.getFriendOne());
            typedQuery.setParameter("friendTwo", relationship.getFriendTwo());

            relationship = typedQuery.getSingleResult();

            transaction = session.beginTransaction();
            session.remove(relationship);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }

            ex.printStackTrace();
            status = false;
        } finally
        {
            session.close();
        }

        return status;
    }

    @Override
    public Relationships GetRelationships(User user)
    {
        String hql = "FROM Relationship r WHERE r.friendOne = :user OR r.friendTwo = :user";

        List<Relationship> relationships;
        Relationships relationshipCollection = new Relationships();

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<Relationship> typedQuery = session.createQuery(hql, Relationship.class);
            typedQuery.setParameter("user", user);

            relationships = typedQuery.getResultList();
            relationshipCollection.setRelationships(relationships);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return relationshipCollection;
    }
}
