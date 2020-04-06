package com.eternitywars.api.Models.Viewmodels.Deck;

import java.util.ArrayList;
import java.util.List;

public class DecksViewmodel
{
    private List<DeckViewmodel> decks;

    public DecksViewmodel()
    {
        this.decks = new ArrayList<>();
    }

    public List<DeckViewmodel> getDecks()
    {
        return decks;
    }

    public void setDecks(List<DeckViewmodel> decks)
    {
        this.decks = decks;
    }
}
