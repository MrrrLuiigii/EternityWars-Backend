package com.eternitywars.api.DAL.Contexts.Deck;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Deck.IDeckContext;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;

public class DeckHibernateContext implements IDeckContext
{
    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;


    @Override
    public boolean AddCard(Deck deck, Card card)
    {
        return false;
    }

    @Override
    public boolean DeleteCard(Deck deck, Card card)
    {
        return false;
    }

    @Override
    public boolean UpdateDeckName(Deck deck)
    {
        return false;
    }
}
