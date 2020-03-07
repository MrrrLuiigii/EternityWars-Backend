package com.eternitywars.api.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deck")
public class Deck
{
    @Id
    @Column(name = "id", unique = true, updatable = false)
    private int deckId;

    @Column(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;



    public Deck(){}

    public Deck(int deckId)
    {
        this.deckId = deckId;
    }

    public Deck(Cards cards, int deckId)
    {
        this.deckId = deckId;
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

    public Cards getCards()
    {
        return null;
    }

}
