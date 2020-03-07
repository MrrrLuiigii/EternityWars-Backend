package com.eternitywars.api.DAL.Contexts.Card;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Card.ICardContainerContext;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class CardContainerHibernateContext implements ICardContainerContext
{
    private static SessionFactory sessionFactory = ApiApplication.getSessionFactory();

    private Session session;
    private Transaction transaction;


    @Override
    public Cards GetCards()
    {
        String hql = "FROM Card";

        List<Card> cards;
        Cards cardCollection = new Cards();

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<Card> typedQuery = session.createQuery(hql, Card.class);

            cards = typedQuery.getResultList();
            cardCollection.setCards(cards);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return cardCollection;
    }

    @Override
    public Cards GetCardsByUser(int userId)
    {
        String hql = "SELECT c FROM Card c INNER JOIN c.cardId";

        List<Card> cards;
        Cards cardCollection = new Cards();

        try
        {
            session = sessionFactory.openSession();
            TypedQuery<Card> typedQuery = session.createQuery(hql, Card.class);

            cards = typedQuery.getResultList();
            cardCollection.setCards(cards);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return cardCollection;
    }

    @Override
    public Card GetCardById(int cardId)
    {
        Card card;

        try
        {
            session = sessionFactory.openSession();
            card = session.find(Card.class, cardId);
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        } finally
        {
            session.close();
        }

        return card;
    }

    @Override
    public boolean AddCard(User user, Card card)
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
            return false;
        } finally
        {
            session.close();
        }

        return true;
    }

    @Override
    public boolean DeleteCard(User user, Card card)
    {
        return false;
    }
}
