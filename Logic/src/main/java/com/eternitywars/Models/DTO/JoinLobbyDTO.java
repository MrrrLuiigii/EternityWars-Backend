package com.eternitywars.Models.DTO;

public class JoinLobbyDTO
{
    int lobbyID;
    int playerID;

    public JoinLobbyDTO()
    {
    }

    public int getLobbyID()
    {
        return lobbyID;
    }

    public void setLobbyID(int lobbyID)
    {
        this.lobbyID = lobbyID;
    }

    public int getPlayerID()
    {
        return playerID;
    }

    public void setPlayerID(int playerID)
    {
        this.playerID = playerID;
    }
}
