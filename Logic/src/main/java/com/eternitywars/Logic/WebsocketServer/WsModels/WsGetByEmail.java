package com.eternitywars.Logic.WebsocketServer.WsModels;

public class WsGetByEmail {
    String token;
    String parameter;

    public WsGetByEmail() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
