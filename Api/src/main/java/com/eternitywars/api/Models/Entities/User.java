package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Enums.AccountStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends Account
{
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gold")
    private int gold;

    @Column(name = "pack_amount")
    private int packAmount;


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
}
