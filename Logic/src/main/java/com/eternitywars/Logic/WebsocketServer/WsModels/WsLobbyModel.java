package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.DTO.LobbyDTO;
import com.eternitywars.Models.Lobby;
import com.eternitywars.Models.User;

public class WsLobbyModel {
    String token;
    LobbyDTO parameter;
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

    public LobbyDTO getParameter() {
        return parameter;
    }

    public void setParameter(LobbyDTO parameter) {
        this.parameter = parameter;
    }

}
