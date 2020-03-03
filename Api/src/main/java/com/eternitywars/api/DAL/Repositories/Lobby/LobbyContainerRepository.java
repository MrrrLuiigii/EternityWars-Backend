package com.eternitywars.api.DAL.Repositories.Lobby;

import com.eternitywars.api.Factories.Lobby.LobbyContainerFactory;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContainerContext;
import com.eternitywars.api.Models.Lobby;
import com.eternitywars.api.Models.Lobbies;

public class LobbyContainerRepository implements ILobbyContainerContext
{
    private ILobbyContainerContext lobbyContainerContext;


    public LobbyContainerRepository()
    {
        LobbyContainerFactory lobbyContainerFactory = new LobbyContainerFactory();
        this.lobbyContainerContext = lobbyContainerFactory.getLobbyContainerSqlContext();
    }

    public LobbyContainerRepository(LobbyContainerFactory lobbyContainerFactory)
    {
        this.lobbyContainerContext = lobbyContainerFactory.getTestLobbyContainerSqlContext();
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
