package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Enums.AccountStatus;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends Account
{
    @Column(name = "email", unique = true, nullable = false, length = 64)
    private String email;

    @Column(name = "gold", nullable = false)
    private int gold;

    @Column(name = "pack_amount", nullable = false)
    private int packAmount;

    @ManyToMany
    @JoinTable(name = "user_card", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Card> cardCollection;

    @ManyToMany(mappedBy = "users")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Chat> chats;

    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Deck> decks;


    public User()
    {
    }

    public User(int userId)
    {
        this.userId = userId;
    }

    public User(String username, String email, AccountStatus accountStatus, int gold, int packAmount)
    {
        this.username = username;
        this.email = email;
        this.accountStatus = accountStatus;
        this.gold = gold;
        this.packAmount = packAmount;
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

    public List<Card> getCardCollection()
    {
        return cardCollection;
    }

    public void setCardCollection(List<Card> cardCollection)
    {
        this.cardCollection = cardCollection;
    }

    public List<Chat> getChats()
    {
        return chats;
    }

    public void setChats(List<Chat> chats)
    {
        this.chats = chats;
    }

    public List<Deck> getDecks()
    {
        return decks;
    }

    public void setDecks(List<Deck> decks)
    {
        this.decks = decks;
    }
}
