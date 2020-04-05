package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.Enums.AccountStatus;

public class WsFrontendUser {
    String email;
    int gold;
    int id;
    int packAmount;
    AccountStatus status;
    String username;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPackAmount() {
        return packAmount;
    }

    public void setPackAmount(int packAmount) {
        this.packAmount = packAmount;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public WsFrontendUser() {
    }
}
