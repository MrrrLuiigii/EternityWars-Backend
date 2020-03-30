package com.eternitywars.api.DAL.Repositories.Deck;

import com.eternitywars.api.Factories.Deck.DeckContainerFactory;
import com.eternitywars.api.Interfaces.Deck.IDeckContainerContext;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Decks;

public class DeckContainerRepository implements IDeckContainerContext
{
    private IDeckContainerContext deckContainerContext;

    public DeckContainerRepository()
    {
        this.deckContainerContext = DeckContainerFactory.getDeckContainerHibernateContext();
    }

    public DeckContainerRepository(IDeckContainerContext deckContainerContext)
    {
        this.deckContainerContext = deckContainerContext;
    }


    public Deck AddDeck(Deck deck)
    {
        return deckContainerContext.AddDeck(deck);
    }

    public boolean DeleteDeck(Deck deck)
    {
        return deckContainerContext.DeleteDeck(deck);
    }

    public Decks GetDecksByUserId(int userId)
    {
        return deckContainerContext.GetDecksByUserId(userId);
    }

    public Deck GetDeckById(int deckId)
    {
        return deckContainerContext.GetDeckById(deckId);
    }
}
