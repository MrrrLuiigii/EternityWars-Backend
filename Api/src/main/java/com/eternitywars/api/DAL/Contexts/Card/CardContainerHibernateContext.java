package com.eternitywars.api.DAL.Contexts.Card;

import com.eternitywars.api.Interfaces.Card.ICardContainerContext;
import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CardContainerHibernateContext implements ICardContainerContext
{
    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public CardContainerHibernateContext()
    {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public Cards GetCards()
    {
        return null;
    }

    @Override
    public Cards GetCardsByUser(int userId)
    {
        return null;
    }

    @Override
    public Card GetCardById(int cardId)
    {
        return null;
    }

    @Override
    public boolean AddCard(User user, Card card)
    {
        return false;
    }

    @Override
    public boolean DeleteCard(User user, Card card)
    {
        return false;
    }
//    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("eternitywars");
//
//    @Override
//    public Cards GetCards()
//    {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        String hql = "FROM Card";
//        TypedQuery<Card> typedQuery = entityManager.createQuery(hql, Card.class);
//        List<Card> cards;
//        Cards cardCollection = new Cards();
//        try
//        {
//            cards = typedQuery.getResultList();
//            cardCollection.setCards(cards);
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        } finally
//        {
//            entityManager.close();
//        }
//
//        return cardCollection;
//    }
//
//    @Override
//    public Cards GetCardsByUser(int userId)
//    {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        String hql = "SELECT c FROM Card c INNER JOIN c.cardId";
//        TypedQuery<Card> typedQuery = entityManager.createQuery(hql, Card.class);
//        List<Card> cards;
//        Cards cardCollection = new Cards();
//        try
//        {
//            cards = typedQuery.getResultList();
//            cardCollection.setCards(cards);
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        } finally
//        {
//            entityManager.close();
//        }
//
//        return cardCollection;
//    }
//
//    @Override
//    public Card GetCardById(int cardId)
//    {
//        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//
//        Card card;
//
//        try
//        {
//            card = entityManager.find(Card.class, cardId);
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//            return null;
//        } finally
//        {
//            entityManager.close();
//        }
//
//        return card;
//    }
//
//    @Override
//    public boolean AddCard(User user, Card card)
//    {
//        return false;
//    }
//
//    @Override
//    public boolean DeleteCard(User user, Card card)
//    {
//        return false;
//    }
}
