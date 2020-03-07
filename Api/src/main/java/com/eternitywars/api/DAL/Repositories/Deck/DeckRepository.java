package com.eternitywars.api.DAL.Repositories.Deck;

import com.eternitywars.api.Factories.Deck.DeckFactory;
import com.eternitywars.api.Interfaces.Deck.IDeckContext;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;

public class DeckRepository implements IDeckContext
{
    private IDeckContext deckContext;

    public DeckRepository()
    {
        this.deckContext = DeckFactory.getDeckHibernateContext();
    }

    public DeckRepository(IDeckContext deckContext)
    {
        this.deckContext = deckContext;
    }


    public boolean AddCard(Deck deck, Card card)
    {
        return deckContext.AddCard(deck, card);
    }

    public boolean DeleteCard(Deck deck, Card card)
    {
        return deckContext.DeleteCard(deck, card);
    }

    public boolean UpdateDeckName(Deck deck)
    {
        return deckContext.UpdateDeckName(deck);
    }
}
