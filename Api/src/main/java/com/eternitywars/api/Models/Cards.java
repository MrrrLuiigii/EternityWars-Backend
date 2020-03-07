package com.eternitywars.api.Models;

import com.eternitywars.api.Models.Entities.Card;

import java.util.ArrayList;
import java.util.List;

public class Cards
{
    private List<Card> cards;

    public Cards()
    {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards()
    {
        return this.cards;
    }

    public void setCards(List<Card> cards)
    {
        this.cards = cards;
    }

    public void AddCard(Card card)
    {
        this.cards.add(card);
    }
}
