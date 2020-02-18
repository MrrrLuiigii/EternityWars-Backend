package com.eternitywars.api.DAL.Contexts.Deck;

import com.eternitywars.api.Interfaces.Deck.IDeckContainerContext;
import com.eternitywars.api.Models.Deck;
import com.eternitywars.api.Models.DeckCollection;

public class DeckContainerHibernateContext implements IDeckContainerContext {
    @Override
    public Deck AddDeck(Deck deck) {
        return null;
    }

    @Override
    public boolean DeleteDeck(Deck deck) {
        return false;
    }

    @Override
    public DeckCollection GetEmptyDecksByUserId(int userId) {
        return null;
    }

    @Override
    public Deck GetEmptyDeckById(int deckId) {
        return null;
    }

    @Override
    public DeckCollection GetDecksByUserId(int userId) {
        return null;
    }

    @Override
    public Deck GetDeckById(int deckId) {
        return null;
    }
}
