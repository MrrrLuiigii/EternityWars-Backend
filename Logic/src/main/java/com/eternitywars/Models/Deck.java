package com.eternitywars.Models;

public class Deck
{
    private int deckId;
    private User user;
    private String name;
    private CardCollection cards;

    public Deck(){
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

    public Deck(int deckId, User user, String name)
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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
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
