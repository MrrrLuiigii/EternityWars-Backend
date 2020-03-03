package com.eternitywars.api.DAL.Repositories.Lobby;

import com.eternitywars.api.DAL.Contexts.Lobby.LobbySqlContext;
import com.eternitywars.api.Factories.Lobby.LobbyFactory;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContext;
import com.eternitywars.api.Models.Lobby;
import com.eternitywars.api.Models.Player;

public class LobbyRepository implements ILobbyContext
{
    private ILobbyContext iLobbyContext;

    public LobbyRepository(ILobbyContext context)
    {
        this.iLobbyContext = context;
    }

    public boolean JoinLobby(Lobby lobby, Player player)
    {
        return iLobbyContext.JoinLobby(lobby, player);
    }

    public boolean LeaveLobby(Lobby lobby, Player player)
    {
        return iLobbyContext.LeaveLobby(lobby, player);
    }

    public boolean UpdatePlayerStatus(Lobby lobby, Player player)
    {
        return iLobbyContext.UpdatePlayerStatus(lobby, player);
    }

    public Lobby UpdatePlayerDeck(Lobby lobby, Player player)
    {
        return iLobbyContext.UpdatePlayerDeck(lobby, player);
    }
}
