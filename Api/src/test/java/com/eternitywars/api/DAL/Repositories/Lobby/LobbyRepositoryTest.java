package com.eternitywars.api.DAL.Repositories.Lobby;

import com.eternitywars.api.DAL.Contexts.Lobby.LobbyHibernateContext;
import com.eternitywars.api.Models.Entities.Lobby;
import org.junit.jupiter.api.Test;

class LobbyRepositoryTest
{
    private LobbyRepository lobbyRepository = new LobbyRepository(new LobbyHibernateContext());


    private Lobby EmptyLobby()
    {
        Lobby lobby = new Lobby();
        lobby.setName("Lobby");
        lobby.setDescription("desc");
        return lobby;
    }

    @Test
    void joinLobby()
    {
        // lobbyRepository.JoinLobby();
    }

    @Test
    void leaveLobby()
    {
        // lobbyRepository.LeaveLobby();
    }

    @Test
    void updatePlayerStatus()
    {
        // lobbyRepository.UpdatePlayerStatus();
    }

    @Test
    void updatePlayerDeck()
    {
        // lobbyRepository.UpdatePlayerDeck();
    }
}