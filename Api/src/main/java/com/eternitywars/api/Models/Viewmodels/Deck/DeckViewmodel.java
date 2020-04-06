package com.eternitywars.api.Models.Viewmodels.Deck;

import com.eternitywars.api.Models.Entities.Card;

import java.util.List;

public class DeckViewmodel
{
    private int deckId;
    private String name;
    private List<Card> cards;

    public DeckViewmodel()
    {
    }

    public DeckViewmodel(int deckId, String name, List<Card> cards)
    {
        this.deckId = deckId;
        this.name = name;
        this.cards = cards;
    }

    public int getDeckId()
    {
        return deckId;
    }

    public void setDeckId(int deckId)
    {
        this.deckId = deckId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Card> getCards()
    {
        return cards;
    }

    public void setCards(List<Card> cards)
    {
        this.cards = cards;
    }
}
