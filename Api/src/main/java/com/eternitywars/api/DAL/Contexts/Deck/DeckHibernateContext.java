package com.eternitywars.api.DAL.Contexts.Deck;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Deck.IDeckContext;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DeckHibernateContext implements IDeckContext
{
    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;


    @Override
    public boolean AddCard(Deck deck)
    {
        boolean status = true;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Card card = deck.getCards().get(0);
            Deck getDeck = session.find(Deck.class, deck.getDeckId());
            getDeck.getCards().add(card);
            session.merge(getDeck);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }

            status = false;
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return status;
    }

    @Override
    public boolean DeleteCard(Deck deck)
    {
        boolean status = true;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Card card = deck.getCards().get(0);
            Deck getDeck = session.find(Deck.class, deck.getDeckId());

            for (Card c : getDeck.getCards())
            {
                if (c.getCardId() == card.getCardId())
                {
                    getDeck.getCards().remove(c);
                }
            }

            session.merge(getDeck);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }

            status = false;
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return status;
    }

    @Override
    public boolean UpdateDeckName(Deck deck)
    {
        boolean status = true;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            String name = deck.getName();
            Deck getDeck = session.find(Deck.class, deck.getDeckId());
            getDeck.setName(name);
            session.merge(getDeck);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }

            status = false;
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return status;
    }
}
