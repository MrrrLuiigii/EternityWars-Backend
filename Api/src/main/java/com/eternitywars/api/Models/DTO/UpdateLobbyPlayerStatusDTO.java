package com.eternitywars.api.Models.DTO;

import com.eternitywars.api.Models.Enums.LobbyPlayerStatus;

public class UpdateLobbyPlayerStatusDTO
{
    private int lobbyID;
    private int playerID;
    private LobbyPlayerStatus status;

    public UpdateLobbyPlayerStatusDTO()
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

    public LobbyPlayerStatus getStatus()
    {
        return status;
    }

    public void setStatus(LobbyPlayerStatus status)
    {
        this.status = status;
    }
}
