package com.eternitywars.api.Models.Viewmodels.User;

import com.eternitywars.api.Models.Enums.AccountStatus;

public class UserViewmodel
{
    private int id;
    private String username;
    private String email;
    private AccountStatus status;

    public UserViewmodel()
    {
    }

    public UserViewmodel(int id, String username, String email, AccountStatus status)
    {
        this.id = id;
        this.username = username;
        this.email = email;
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
}
