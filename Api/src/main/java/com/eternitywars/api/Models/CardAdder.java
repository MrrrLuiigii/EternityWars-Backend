package com.eternitywars.api.Models;

import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.User;

public class CardAdder
{
    private User user;
    private Card card;

    public CardAdder()
    {
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }
}