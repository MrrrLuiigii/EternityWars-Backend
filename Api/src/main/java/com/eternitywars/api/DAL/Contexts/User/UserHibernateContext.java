package com.eternitywars.api.DAL.Contexts.User;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.User.IUserContext;
import com.eternitywars.api.Models.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserHibernateContext implements IUserContext
{
    private static SessionFactory sessionFactory = ApiApplication.getSessionFactory();

    private Session session;
    private Transaction transaction;

    private User returnUser;

    @Override
    public boolean UpdateUsername(User user)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            returnUser = session.find(User.class, user.getUserId());
            returnUser.setUsername(user.getUsername());

            session.persist(returnUser);
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

    @Override
    public boolean UpdateAccountStatus(User user)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            returnUser = session.find(User.class, user.getUserId());
            returnUser.setAccountStatus(user.getAccountStatus());

            session.persist(returnUser);
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

    @Override
    public boolean UpdatePackAmount(User user)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            returnUser = session.find(User.class, user.getUserId());
            returnUser.setPackAmount(user.getPackAmount());

            session.persist(returnUser);
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

    @Override
    public boolean UpdateGold(User user)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            returnUser = session.find(User.class, user.getUserId());
            returnUser.setGold(user.getGold());

            session.persist(returnUser);
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
