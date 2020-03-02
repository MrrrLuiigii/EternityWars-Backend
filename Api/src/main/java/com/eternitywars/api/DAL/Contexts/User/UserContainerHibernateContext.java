package com.eternitywars.api.DAL.Contexts.User;

import com.eternitywars.api.Interfaces.User.IUserContainerContext;
import com.eternitywars.api.Models.User;
import com.eternitywars.api.Models.UserCollection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UserContainerHibernateContext implements IUserContainerContext {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("eternitywars");
    @Override
    public User GetUserById(int userId) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "SELECT c FROM User c WHERE c.id = :userID";
        TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
        typedQuery.setParameter("userID", userId);
        User user = null;
        try {
            user = typedQuery.getSingleResult();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return user;
    }

    @Override
    public User GetUserByUsername(String username) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "SELECT c FROM User c WHERE c.username = :username";
        TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
        typedQuery.setParameter("username", username);
        User user = null;
        try {
            user = typedQuery.getSingleResult();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return user;
    }

    @Override
    public User GetUserByEmail(String userEmail){
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    String hql = "SELECT c FROM User c WHERE c.email = :email";
    TypedQuery<User> typedQuery = entityManager.createQuery(hql, User.class);
        typedQuery.setParameter("email", userEmail);
    User user = null;
        try {
        user = typedQuery.getSingleResult();

    }catch (Exception ex){
        ex.printStackTrace();
    }
        finally {
        entityManager.close();
    }
        return user;
    }

    @Override
    public UserCollection GetUsers() {
        return null;
    }

    @Override
    public User AddUser(User user) {
        return null;
    }

    @Override
    public boolean DeleteUser(User user) {
        return false;
    }
}
