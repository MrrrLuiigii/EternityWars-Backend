package com.eternitywars.api.DAL.Contexts.User;

import com.eternitywars.api.Interfaces.User.IUserContext;
import com.eternitywars.api.Models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserHibernateContext implements IUserContext {
    @Override
    public boolean UpdateUsername(User user)
    {
        return false;
    }

    @Override
    public boolean UpdateAccountStatus(User user)
    {
        return false;
    }

    @Override
    public boolean UpdatePackAmount(User user)
    {
        return false;
    }

    @Override
    public boolean UpdateGold(User user)
    {
        return false;
    }
//    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("eternitywars");
//    @Override
//    public boolean UpdateUsername(User user) {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction entityTransaction = null;
//        User returnUser = null;
//        try {
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            returnUser = entityManager.find(User.class, user.getUserId());
//            returnUser.setUsername(user.getUsername());
//
//            entityManager.persist(returnUser);
//            entityTransaction.commit();
//        }catch (Exception ex){
//            if(entityTransaction != null){
//                entityTransaction.rollback();
//            }
//            ex.printStackTrace();
//        }
//        finally {
//            entityManager.close();
//        }
//        return true;
//    }
//
//    @Override
//    public boolean UpdateAccountStatus(User user) {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction entityTransaction = null;
//        User returnUser = null;
//        try {
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            returnUser = entityManager.find(User.class, user.getUserId());
//            returnUser.setAccountStatus(user.getAccountStatus());
//
//            entityManager.persist(returnUser);
//            entityTransaction.commit();
//        }catch (Exception ex){
//            if(entityTransaction != null){
//                entityTransaction.rollback();
//            }
//            ex.printStackTrace();
//        }
//        finally {
//            entityManager.close();
//        }
//        return true;
//    }
//
//    @Override
//    public boolean UpdatePackAmount(User user) {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction entityTransaction = null;
//        User returnUser = null;
//        try {
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            returnUser = entityManager.find(User.class, user.getUserId());
//            returnUser.setPackAmount(user.getPackAmount());
//
//            entityManager.persist(returnUser);
//            entityTransaction.commit();
//        }catch (Exception ex){
//            if(entityTransaction != null){
//                entityTransaction.rollback();
//            }
//            ex.printStackTrace();
//        }
//        finally {
//            entityManager.close();
//        }
//        return true;
//    }
//
//    @Override
//    public boolean UpdateGold(User user) {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction entityTransaction = null;
//        User returnUser = null;
//        try {
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            returnUser = entityManager.find(User.class, user.getUserId());
//            returnUser.setGold(user.getGold());
//
//            entityManager.persist(returnUser);
//            entityTransaction.commit();
//        }catch (Exception ex){
//            if(entityTransaction != null){
//                entityTransaction.rollback();
//            }
//            ex.printStackTrace();
//        }
//        finally {
//            entityManager.close();
//        }
//        return true;
//    }
}
