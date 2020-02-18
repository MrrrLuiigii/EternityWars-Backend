package com.eternitywars.api.DAL.Contexts.Deck;

import com.eternitywars.api.Interfaces.Deck.IDeckContext;
import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.Deck;

public class DeckHibernateContext implements IDeckContext {
    @Override
    public boolean AddCard(Deck deck, Card card) {
        return false;
    }

    @Override
    public boolean DeleteCard(Deck deck, Card card) {
        return false;
    }

    @Override
    public boolean UpdateDeckName(Deck deck) {
        return false;
    }
}
