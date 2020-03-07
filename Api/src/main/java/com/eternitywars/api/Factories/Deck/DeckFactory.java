package com.eternitywars.api.Factories.Deck;

import com.eternitywars.api.DAL.Contexts.Deck.DeckHibernateContext;
import com.eternitywars.api.Interfaces.Deck.IDeckContext;

public class DeckFactory
{
    public static IDeckContext getDeckHibernateContext()
    {
        return new DeckHibernateContext();
    }

    public static IDeckContext getTestDeckHibernateContext()
    {
        return new DeckHibernateContext();
    }
}
