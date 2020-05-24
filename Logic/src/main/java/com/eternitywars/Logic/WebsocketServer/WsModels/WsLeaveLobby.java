package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.Viewmodels.Lobby.LobbyViewmodel;
import com.eternitywars.Models.Viewmodels.SingleUserViewmodel;

public class WsLeaveLobby
{
    private String token;
    private LobbyViewmodel lobby;
    private SingleUserViewmodel user;


    public WsLeaveLobby()
    {
    }

    public SingleUserViewmodel getUser()
    {
        return user;
    }

    public void setUser(SingleUserViewmodel user)
    {
        this.user = user;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public LobbyViewmodel getLobby()
    {
        return lobby;
    }

    public void setLobby(LobbyViewmodel lobby)
    {
        this.lobby = lobby;
    }
}
