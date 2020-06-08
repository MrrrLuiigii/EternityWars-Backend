package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.Player;
import com.eternitywars.Models.Viewmodels.Lobby.LobbyViewmodel;

public class WsSetDeck {
    LobbyViewmodel lobby;
    Player player;
    String token;

    public WsSetDeck() {
    }

    public LobbyViewmodel getLobby() {
        return lobby;
    }

    public void setLobby(LobbyViewmodel lobby) {
        this.lobby = lobby;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
