package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.DTO.DeckDTO;
import com.eternitywars.Models.DTO.LobbyDTO;
import com.eternitywars.Models.DTO.LobbyPlayerDTO;
import com.eternitywars.Models.Deck;
import com.eternitywars.Models.Player;
import com.eternitywars.Models.Viewmodels.Lobby.LobbyViewmodel;

public class WsSetDeck {
    LobbyViewmodel lobby;
    String username;
    DeckDTO selectedDeck;
    String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public WsSetDeck() {
    }

    public LobbyViewmodel getLobby() {
        return lobby;
    }

    public void setLobby(LobbyViewmodel lobby) {
        this.lobby = lobby;
    }

    public DeckDTO getSelectedDeck() {
        return selectedDeck;
    }

    public void setSelectedDeck(DeckDTO selectedDeck) {
        this.selectedDeck = selectedDeck;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }
}
