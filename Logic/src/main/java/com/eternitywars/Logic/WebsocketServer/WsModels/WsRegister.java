package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.User;

public class WsRegister {
    String token;
    User parameter;

    public WsRegister() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getParameter() {
        return parameter;
    }

    public void setParameter(User parameter) {
        this.parameter = parameter;
    }
}
