package com.eternitywars.api.DAL.Repositories.Lobby;

import com.eternitywars.api.Factories.Lobby.LobbyContainerFactory;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContainerContext;
import com.eternitywars.api.Models.Lobbies;
import com.eternitywars.api.Models.Entities.Lobby;

public class LobbyContainerRepository implements ILobbyContainerContext
{
    private ILobbyContainerContext lobbyContainerContext;

    public LobbyContainerRepository()
    {
        this.lobbyContainerContext = LobbyContainerFactory.getLobbyContainerHibernateContext();
    }

    public LobbyContainerRepository(ILobbyContainerContext lobbyContainerContext)
    {
        this.lobbyContainerContext = lobbyContainerContext;
    }
    

    public Lobby AddLobby(Lobby lobby)
    {
        return lobbyContainerContext.AddLobby(lobby);
    }

    public boolean DeleteLobby(Lobby lobby)
    {
        return lobbyContainerContext.DeleteLobby(lobby);
    }

    public Lobby GetLobbyById(int lobbyId)
    {
        return lobbyContainerContext.GetLobbyById(lobbyId);
    }

    public Lobbies GetLobbies()
    {
        return lobbyContainerContext.GetLobbies();
    }
}
