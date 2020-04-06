package com.eternitywars.Logic.WebsocketServer.WsModels;

public class WsGetDeckByUserId {
    String token;
    WsFrontendUser parameter;

    public WsGetDeckByUserId() {
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
