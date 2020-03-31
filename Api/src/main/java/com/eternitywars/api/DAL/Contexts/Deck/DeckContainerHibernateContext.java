package com.eternitywars.api.DAL.Contexts.Deck;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Deck.IDeckContainerContext;
import com.eternitywars.api.Models.Decks;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DeckContainerHibernateContext implements IDeckContainerContext
{
    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;


    @Override
    public Deck AddDeck(Deck deck)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            User user = session.find(User.class, deck.getUser().getUserId());
            deck.setUser(user);
            user.getDecks().add(deck);
            session.persist(deck);
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

        return deck;
    }

    @Override
    public boolean DeleteDeck(Deck deck)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(deck);
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
    public Decks GetDecksByUserId(int userId)
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

        Decks decks = new Decks();

        for (Deck d : user.getDecks())
        {
            decks.AddDeck(d);
        }

        return decks;
    }

    @Override
    public Deck GetDeckById(int deckId)
    {
        Deck deck;

        try
        {
            session = sessionFactory.openSession();
            deck = session.find(Deck.class, deckId);
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        } finally
        {
            session.close();
        }

        return deck;
    }
}
