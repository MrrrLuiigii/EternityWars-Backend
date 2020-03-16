package com.eternitywars.api.Models.Entities;


import com.eternitywars.api.Models.Cards;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "deck")
public class Deck
{
    @Id
    @Column(name = "id", unique = true, updatable = false)
    private int deckId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

//    @OneToMany(mappedBy = "deck", fetch = FetchType.EAGER)
//    private List<DeckCard> deckCards;

    public Deck()
    {
    }

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

//    public List<DeckCard> getDeckCards()
//    {
//        return deckCards;
//    }
//
//    public void setDeckCards(List<DeckCard> deckCards)
//    {
//        this.deckCards = deckCards;
//    }
}
