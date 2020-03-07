package com.eternitywars.api.DAL.Repositories.Lobby;

import com.eternitywars.api.DAL.Contexts.Lobby.LobbyContainerHibernateContext;
import com.eternitywars.api.Models.Lobby;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LobbyContainerRepositoryTest
{
    private LobbyContainerRepository lobbyContainerRepository = new LobbyContainerRepository(new LobbyContainerHibernateContext());
    private Lobby addedLobby;

    private Lobby SetupLobby()
    {
        Lobby lobby = new Lobby();
        lobby.setName("TestLobby");
        lobby.setDescription("desc");
        // lobby.setPlayerOne(new Player());
        //lobby.getPlayerOne().setUserId(1);
        return lobby;
    }

    @Test
    void addLobby()
    {
        Lobby lobbyToAdd = SetupLobby();
        addedLobby = lobbyContainerRepository.AddLobby(lobbyToAdd);

        assertEquals(lobbyToAdd.getName(), addedLobby.getName());
    }

    @Test
    void deleteLobby()
    {

        assertEquals(true, lobbyContainerRepository.DeleteLobby(addedLobby));
    }

    @Test
    void getLobbyById()
    {
        Lobby lobbyToAdd = SetupLobby();
        addedLobby = lobbyContainerRepository.AddLobby(lobbyToAdd);
        Lobby returnlobby = lobbyContainerRepository.GetLobbyById(addedLobby.getId());
        lobbyContainerRepository.DeleteLobby(addedLobby);
        assertEquals(lobbyToAdd.getName(), returnlobby.getName());
    }

    @Test
    void getLobbies()
    {
        Lobby lobbyToAdd = SetupLobby();
        addedLobby = lobbyContainerRepository.AddLobby(lobbyToAdd);
        assertEquals(1, lobbyContainerRepository.GetLobbies().getLobbies().size());
    }

    @AfterAll
    void Reset()
    {
        lobbyContainerRepository.DeleteLobby(addedLobby);
    }


}