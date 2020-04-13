package com.eternitywars.api.DAL.Repositories.Lobby;

import com.eternitywars.api.Factories.Lobby.LobbyFactory;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContext;
import com.eternitywars.api.Models.DTO.JoinLobbyDTO;
import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.Player;

public class LobbyRepository implements ILobbyContext
{
    private ILobbyContext lobbyContext;

    public LobbyRepository()
    {
        this.lobbyContext = LobbyFactory.getLobbyHibernateContext();
    }

    public LobbyRepository(ILobbyContext context)
    {
        this.lobbyContext = context;
    }


    public boolean JoinLobby(JoinLobbyDTO lobby)
    {
        return lobbyContext.JoinLobby(lobby);
    }

    public boolean LeaveLobby(Lobby lobby, Player player)
    {
        return lobbyContext.LeaveLobby(lobby, player);
    }

    public boolean UpdatePlayerStatus(Lobby lobby, Player player)
    {
        return lobbyContext.UpdatePlayerStatus(lobby, player);
    }

    public Lobby UpdatePlayerDeck(Lobby lobby, Player player)
    {
        return lobbyContext.UpdatePlayerDeck(lobby, player);
    }
}
