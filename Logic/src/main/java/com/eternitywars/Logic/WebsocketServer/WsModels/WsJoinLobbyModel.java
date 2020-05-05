package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.DTO.LobbyDTO;
import com.eternitywars.Models.Player;
import com.eternitywars.Models.User;

public class WsJoinLobbyModel
{
    String token;
    LobbyDTO parameter;
    Player player;

    public WsJoinLobbyModel()
    {
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public LobbyDTO getParameter()
    {
        return parameter;
    }

    public void setParameter(LobbyDTO parameter)
    {
        this.parameter = parameter;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
}
