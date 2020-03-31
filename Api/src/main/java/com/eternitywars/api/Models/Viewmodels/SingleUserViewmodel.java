package com.eternitywars.api.Models.Viewmodels;

import com.eternitywars.api.Models.Enums.AccountStatus;

public class SingleUserViewmodel
{
    private int id;
    private String username;
    private String email;
    private AccountStatus status;
    private int gold;
    private int packAmount;

    public SingleUserViewmodel()
    {
    }

    public SingleUserViewmodel(int id, String username, String email, AccountStatus status, int gold, int packAmount)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.status = status;
        this.gold = gold;
        this.packAmount = packAmount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public AccountStatus getStatus()
    {
        return status;
    }

    public void setStatus(AccountStatus status)
    {
        this.status = status;
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
