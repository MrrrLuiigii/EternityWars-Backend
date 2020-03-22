package com.eternitywars.api.DAL.Contexts.User;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.User.IUserContainerContext;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserContainerHibernateContext implements IUserContainerContext
{
    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;


    @Override
    public User GetUserById(int userId)
    {
        User user;

        try
        {
            session = sessionFactory.openSession();
            user = session.find(User.class, userId);
        } catch (Exception ex)
        {
            return null;
        } finally
        {
            session.close();
        }

        return user;
    }

    @Override
    public User GetUserByUsername(String username)
    {
        String hql = "SELECT c FROM User c WHERE c.username = :username";

        User user = null;

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
            typedQuery.setParameter("username", username);

            user = typedQuery.getSingleResult();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return user;
    }

    @Override
    public User GetUserByEmail(String userEmail)
    {
        String hql = "SELECT c FROM User c WHERE c.email = :email";

        User user = null;

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
            typedQuery.setParameter("email", userEmail);

            user = typedQuery.getSingleResult();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return user;
    }

    @Override
    public Users GetUsers()
    {
        String hql = "FROM User";

        List<User> users;
        Users userCollection = new Users();

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

            users = typedQuery.getResultList();
            userCollection.setUsers(users);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return userCollection;
    }

    @Override
    public User AddUser(User user)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(user);
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

        return user;
    }

    @Override
    public boolean DeleteUser(User user)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(user);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        } finally
        {
            session.close();
        }

        return true;
    }
}
