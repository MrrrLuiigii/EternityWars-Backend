package com.eternitywars.api.DAL.Contexts.User;

import com.eternitywars.api.Interfaces.User.IUserContainerContext;
import com.eternitywars.api.Models.User;
import com.eternitywars.api.Models.Users;

import javax.persistence.*;
import java.util.List;

public class UserContainerHibernateContext implements IUserContainerContext
{
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("eternitywars");

    @Override
    public User GetUserById(int userId)
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        User user;

        try
        {
            user = entityManager.find(User.class, userId);
        } catch (Exception ex)
        {
            return null;
        } finally
        {
            entityManager.close();
        }

        return user;
    }

    @Override
    public User GetUserByUsername(String username)
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "SELECT c FROM User c WHERE c.username = :username";
        TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
        typedQuery.setParameter("username", username);
        User user = null;
        try
        {
            user = typedQuery.getSingleResult();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            entityManager.close();
        }

        return user;
    }

    @Override
    public User GetUserByEmail(String userEmail)
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "SELECT c FROM User c WHERE c.email = :email";
        TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
        typedQuery.setParameter("email", userEmail);
        User user = null;
        try
        {
            user = typedQuery.getSingleResult();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            entityManager.close();
        }

        return user;
    }

    @Override
    public Users GetUsers()
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "FROM User";
        TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
        List<User> users;
        Users userCollection = new Users();
        try
        {
            users = typedQuery.getResultList();
            userCollection.setUsers(users);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            entityManager.close();
        }

        return userCollection;
    }

    @Override
    public User AddUser(User user)
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        try
        {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
        } catch (Exception ex)
        {
            if (entityTransaction != null)
            {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
        } finally
        {
            entityManager.close();
        }

        return user;
    }

    @Override
    public boolean DeleteUser(User user)
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        User returnUser = null;
        try
        {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            returnUser = entityManager.find(User.class, user.getUserId());
            entityManager.remove(returnUser);

            entityTransaction.commit();
        } catch (Exception ex)
        {
            if (entityTransaction != null)
            {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
            return false;
        } finally
        {
            entityManager.close();
        }

        return true;
    }
}
