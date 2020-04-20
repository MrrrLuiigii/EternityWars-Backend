package com.eternitywars.api.Models.DTO;

public class UpdatePlayerDeckDTO
{
    private int lobbyID;
    private int playerID;
    private int playerDeckID;

    public UpdatePlayerDeckDTO()
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

    public int getPlayerDeckID()
    {
        return playerDeckID;
    }

    public void setPlayerDeckID(int playerDeckID)
    {
        this.playerDeckID = playerDeckID;
    }
}
