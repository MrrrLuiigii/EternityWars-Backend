package com.eternitywars.api.Models.Enums;

import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.User;

import javax.persistence.*;

@Entity
@Table(name = "card_collection")
public class CardCollection
{
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
