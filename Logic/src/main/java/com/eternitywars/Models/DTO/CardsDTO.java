package com.eternitywars.Models.DTO;

import com.eternitywars.Models.Card;

import java.util.ArrayList;
import java.util.List;

public class CardsDTO {
    private List<Card> cards;

    public CardsDTO()
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
