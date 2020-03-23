package com.eternitywars.api.DAL.Contexts.Card;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Card.ICardContainerContext;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.CardCollection;
import com.eternitywars.api.Models.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class CardContainerHibernateContext implements ICardContainerContext
{
    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

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

        Cards cards = new Cards();

        for (CardCollection cc : user.getCardCollection())
        {
            cards.getCards().add(cc.getCard());
        }

        return cards;
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
        CardCollection cardCollection = new CardCollection();
        cardCollection.setUser(user);
        cardCollection.setCard(card);

        boolean status = true;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(cardCollection);
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
    public boolean DeleteCard(User user, Card card)
    {
        CardCollection cardCollection = new CardCollection();
        cardCollection.setUser(user);
        cardCollection.setCard(card);

        String hql = "SELECT c FROM CardCollection c WHERE c.user = :user AND c.card = :card";

        boolean status = true;

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<CardCollection> typedQuery = session.createQuery(hql, CardCollection.class);
            typedQuery.setParameter("user", user);
            typedQuery.setParameter("card", card);

            cardCollection = typedQuery.getSingleResult();

            transaction = session.beginTransaction();
            session.remove(cardCollection);
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
}
