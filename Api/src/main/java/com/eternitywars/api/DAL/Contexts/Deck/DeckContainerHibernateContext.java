package com.eternitywars.api.DAL.Contexts.Deck;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Deck.IDeckContainerContext;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.Decks;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;

public class DeckContainerHibernateContext implements IDeckContainerContext
{
    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;


    @Override
    public Deck AddDeck(Deck deck)
    {
        return null;
    }

    @Override
    public boolean DeleteDeck(Deck deck)
    {
        return false;
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

        Cards cards = new Cards();

        for (Card c : user.getCardCollection())
        {
            cards.AddCard(c);
        }

        return null;
    }

    @Override
    public Deck GetDeckById(int deckId)
    {
        return null;
    }
}
