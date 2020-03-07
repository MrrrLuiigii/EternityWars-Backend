package com.eternitywars.api.Models;

import com.eternitywars.api.Models.Entities.Deck;

import java.util.ArrayList;
import java.util.List;

public class Decks
{
    private List<Deck> decks;

    public Decks()
    {
        this.decks = new ArrayList<>();
    }

    public List<Deck> getDecks()
    {
        return decks;
    }

    public void AddDeck(Deck deck){ decks.add(deck);}
}
