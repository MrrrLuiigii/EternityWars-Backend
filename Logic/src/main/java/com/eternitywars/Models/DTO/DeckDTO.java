package com.eternitywars.Models.DTO;

import com.eternitywars.Models.Card;
import com.eternitywars.Models.User;

import java.util.List;

public class DeckDTO {

    private int deckId;

    private User user;

    private String name;

    private List<Card> cards;

    public DeckDTO()
    {
    }

    public DeckDTO(int deckId)
    {
        this.deckId = deckId;
    }

    public DeckDTO(int deckId, User user, String name)
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

    public List<Card> getCards()
    {
        return cards;
    }

    public void setCards(List<Card> cards)
    {
        this.cards = cards;
    }
}
