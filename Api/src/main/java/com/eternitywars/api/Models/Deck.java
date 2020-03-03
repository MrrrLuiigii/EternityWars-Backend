package com.eternitywars.api.Models;


//@Entity
//@Table(name = "deck")
public class Deck
{
//    @Id
//    @Column(name = "id", unique = true)
    private int deckId;

//    @Column()
    private int userId;

//    @Column(name = "name", nullable = false)
    private String name;


    private Cards cards;

    public Deck(){}

    public Deck(int deckId)
    {
        this.deckId = deckId;
    }

    public Deck(Cards cards, int deckId)
    {
        this.deckId = deckId;
        this.cards = cards;
    }

    public Deck(int deckId, int userId, String name)
    {
        this.deckId = deckId;
        this.userId = userId;
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

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Cards getCards()
    {
        return cards;
    }

    public void setCards(Cards cards)
    {
        this.cards = cards;
    }
}
