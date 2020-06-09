package com.eternitywars.Models;

import com.eternitywars.Logic.WebsocketServer.WsModels.WsFrontendUser;
import com.eternitywars.Models.DTO.DeckDTO;

public class Deck
{
    private int deckId;
    private WsFrontendUser user;
    private String name;
    private CardCollection cards;

    public Deck(){
    }

    public Deck(DeckDTO deck) {
        this.deckId = deck.getDeckId();
        this.name = deck.toString();
        this.cards = new CardCollection();
        cards.setCards(deck.getCards());
    }

    public Deck(int deckId)
    {
        this.deckId = deckId;
    }

    public Deck(CardCollection cards, int deckId)
    {
        this.deckId = deckId;
        this.cards = cards;
    }

    public Deck(int deckId, WsFrontendUser user, String name)
    {
        this.deckId = deckId;
        this.user = user;
        this.name = name;
    }

    public int getDeckId()
    {
        return deckId;
    }

    public void setDeckId(int deckId)
    {
        this.deckId = deckId;
    }

    public WsFrontendUser getUser()
    {
        return user;
    }

    public void setUser(WsFrontendUser user)
    {
        this.user = user;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public CardCollection getCards()
    {
        return cards;
    }

    public void setCards(CardCollection cards)
    {
        this.cards = cards;
    }
}
