package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.User;

public class WsAddUser {
    String token;
    User user;

    public WsAddUser() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
