package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.User;

public class WsUserToken {
    String token;
    WsFrontendUser parameter;

    public WsUserToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public WsFrontendUser getParameter() {
        return parameter;
    }

    public void setParameter(WsFrontendUser parameter) {
        this.parameter = parameter;
    }
}
