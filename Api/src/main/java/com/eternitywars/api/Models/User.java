package com.eternitywars.api.Models;

import com.eternitywars.api.Models.Enums.AccountStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends Account implements Serializable
{
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gold")
    private int gold;

    @Column(name = "pack_amount")
    private int packAmount;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "card_collection",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "card_id"))
//    private List<Card> cards;

    public User()
    {
    }

    public User(int userId)
    {
        this.userId = userId;
    }

    public User(int id, String email, String username, AccountStatus accountStatus, int gold, int packAmount)
    {
        super(id, username, accountStatus);
        this.email = email;
        this.gold = gold;
        this.packAmount = packAmount;
    }

    public User(int id, String username, AccountStatus accountStatus, String email, int gold, int packAmount)
    {
        super(id, username, accountStatus);
        this.email = email;
        this.gold = gold;
        this.packAmount = packAmount;

    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

    public int getPackAmount()
    {
        return packAmount;
    }

    public void setPackAmount(int packAmount)
    {
        this.packAmount = packAmount;
    }

//    public List<Card> getCards()
//    {
//        return cards;
//    }
//
//    public void setCards(List<Card> cards)
//    {
//        this.cards = cards;
//    }
}
