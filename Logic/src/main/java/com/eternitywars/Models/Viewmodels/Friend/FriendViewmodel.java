package com.eternitywars.Models.Viewmodels.Friend;

import com.eternitywars.Models.Enums.AccountStatus;


public class FriendViewmodel
{
    private int id;
    private String username;
    private AccountStatus status;

    public FriendViewmodel(int id, String username, AccountStatus status)
    {
        this.id = id;
        this.username = username;
        this.status = status;
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

    public AccountStatus getStatus()
    {
        return status;
    }

    public void setStatus(AccountStatus status)
    {
        this.status = status;
    }
}
