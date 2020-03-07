package com.eternitywars.api.Factories.Deck;

import com.eternitywars.api.DAL.Contexts.Deck.DeckContainerHibernateContext;
import com.eternitywars.api.Interfaces.Deck.IDeckContainerContext;

public class DeckContainerFactory
{
    public static IDeckContainerContext getTestDeckContainerHibernateContext()
    {
        return new DeckContainerHibernateContext();
    }

    public static IDeckContainerContext getDeckContainerHibernateContext()
    {
        return new DeckContainerHibernateContext();
    }
}
