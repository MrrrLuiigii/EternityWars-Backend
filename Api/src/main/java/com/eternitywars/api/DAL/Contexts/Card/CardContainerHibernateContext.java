package com.eternitywars.api.DAL.Contexts.Card;

import com.eternitywars.api.Interfaces.Card.ICardContainerContext;
import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CardContainerHibernateContext implements ICardContainerContext
{
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("eternitywars");

    @Override
    public Cards GetCards()
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "FROM Card";
        TypedQuery<Card> typedQuery = entityManager.createQuery(hql, Card.class);
        List<Card> cards;
        Cards cardCollection = new Cards();
        try
        {
            cards = typedQuery.getResultList();
            cardCollection.setCards(cards);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            entityManager.close();
        }

        return cardCollection;
    }

    @Override
    public Cards GetCardsByUser(int userId)
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "FROM Card";
        TypedQuery<Card> typedQuery = entityManager.createQuery(hql, Card.class);
        List<Card> cards;
        Cards cardCollection = new Cards();
        try
        {
            cards = typedQuery.getResultList();
            cardCollection.setCards(cards);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            entityManager.close();
        }

        return cardCollection;
    }

    @Override
    public Card GetCardById(int cardId)
    {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        Card card;

        try
        {
            card = entityManager.find(Card.class, cardId);
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        } finally
        {
            entityManager.close();
        }

        return card;
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
}
