package com.eternitywars.api.Factories.Card;

import com.eternitywars.api.DAL.Contexts.Card.CardContainerHibernateContext;
import com.eternitywars.api.Interfaces.Card.ICardContainerContext;

public class CardContainerFactory
{
    public static ICardContainerContext getCardContainerHibernateContext()
    {
        return new CardContainerHibernateContext();
    }

    public static ICardContainerContext getTestCardContainerHibernateContext()
    {
        return new CardContainerHibernateContext();
    }
}
