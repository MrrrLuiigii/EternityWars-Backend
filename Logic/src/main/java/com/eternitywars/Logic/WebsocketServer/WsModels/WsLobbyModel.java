package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.Lobby;
import com.eternitywars.Models.User;

public class WsLobbyModel {
    String token;
    Lobby parameter;
    WsFrontendUser user;

    public WsFrontendUser getUser() {
        return user;
    }

    public void setUser(WsFrontendUser user) {
        this.user = user;
    }

    public WsLobbyModel() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Lobby getParameter() {
        return parameter;
    }

    public void setParameter(Lobby parameter) {
        this.parameter = parameter;
    }

}
