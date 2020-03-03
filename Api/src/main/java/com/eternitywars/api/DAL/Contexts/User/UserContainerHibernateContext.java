package com.eternitywars.api.DAL.Contexts.User;

import com.eternitywars.api.Interfaces.User.IUserContainerContext;
import com.eternitywars.api.Models.User;
import com.eternitywars.api.Models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserContainerHibernateContext implements IUserContainerContext
{
    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public UserContainerHibernateContext()
    {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public User GetUserById(int userId)
    {
        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();

        User user;

        try
        {
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
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        String hql = "SELECT c FROM User c WHERE c.username = :username";
//        TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
//        typedQuery.setParameter("username", username);
//        User user = null;
//        try
//        {
//            user = typedQuery.getSingleResult();
//
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        } finally
//        {
//            entityManager.close();
//        }
//
//        return user;
        return null;
    }

    @Override
    public User GetUserByEmail(String userEmail)
    {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        String hql = "SELECT c FROM User c WHERE c.email = :email";
//        TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
//        typedQuery.setParameter("email", userEmail);
//        User user = null;
//        try
//        {
//            user = typedQuery.getSingleResult();
//
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        } finally
//        {
//            entityManager.close();
//        }
//
//        return user;

        return null;
    }

    @Override
    public Users GetUsers()
    {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        String hql = "FROM User";
//        TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
//        List<User> users;
//        Users userCollection = new Users();
//        try
//        {
//            users = typedQuery.getResultList();
//            userCollection.setUsers(users);
//
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        } finally
//        {
//            entityManager.close();
//        }
//
//        return userCollection;

        return null;
    }

    @Override
    public User AddUser(User user)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try
        {
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
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction entityTransaction = null;
//        User returnUser = null;
//        try
//        {
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            returnUser = entityManager.find(User.class, user.getUserId());
//            entityManager.remove(returnUser);
//
//            entityTransaction.commit();
//        } catch (Exception ex)
//        {
//            if (entityTransaction != null)
//            {
//                entityTransaction.rollback();
//            }
//            ex.printStackTrace();
//            return false;
//        } finally
//        {
//            entityManager.close();
//        }

        return true;
    }
}
