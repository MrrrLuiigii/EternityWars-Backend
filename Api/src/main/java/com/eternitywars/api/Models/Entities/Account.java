package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Enums.AccountStatus;

import javax.persistence.*;
import javax.websocket.Session;
import java.net.Socket;

@MappedSuperclass
public abstract class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    protected int userId;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    protected String username;

    @Column(name = "account_status", columnDefinition = "int default 0", nullable = false)
    protected AccountStatus accountStatus;

    public Account(){}

    public Account(int userId, String username, AccountStatus accountStatus)
    {
        this.userId = userId;
        this.username = username;
        this.accountStatus = accountStatus;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public AccountStatus getAccountStatus()
    {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus)
    {
        this.accountStatus = accountStatus;
    }

}
