package com.eternitywars.api.Models.DTO;

public class JoinLobbyDTO {
    int lobbyID;
    int playerID;

    public int getLobbyID() {
        return lobbyID;
    }

    public void setLobbyID(int lobbyID) {
        this.lobbyID = lobbyID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public JoinLobbyDTO() {
    }
}
