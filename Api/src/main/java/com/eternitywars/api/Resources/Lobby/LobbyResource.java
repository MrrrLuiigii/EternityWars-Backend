package com.eternitywars.api.Resources.Lobby;

import com.eternitywars.api.DAL.Repositories.Lobby.LobbyContainerRepository;
import com.eternitywars.api.DAL.Repositories.Lobby.LobbyRepository;
import com.eternitywars.api.Factories.Lobby.LobbyContainerFactory;
import com.eternitywars.api.Factories.Lobby.LobbyFactory;
import com.eternitywars.api.Models.Lobby;
import com.eternitywars.api.Models.Player;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/private/lobby")
public class LobbyResource
{
    private LobbyRepository lobbyRepository = new LobbyRepository(LobbyFactory.getLobbyHibernateContext());
    private LobbyContainerRepository lobbyContainerRepository = new LobbyContainerRepository(LobbyContainerFactory.getLobbyContainerHibernateContext());

    @PostMapping(value = "/join", consumes = "application/json", produces = "application/json")
    public boolean Join(@RequestBody Lobby lobby)
    {
        Player player = lobby.getPlayerTwo();
        return lobbyRepository.JoinLobby(lobby, player);
    }

    @PostMapping(value = "/leave", consumes = "application/json", produces = "application/json")
    public boolean Leave(@RequestBody Lobby lobby)
    {
        Player player = lobby.getPlayerOne();
        return lobbyRepository.LeaveLobby(lobby, player);
    }

    @PutMapping(value = "/updateDeck", consumes = "application/json", produces = "application/json")
    public Lobby UpdatePlayerDeck(@RequestBody Lobby lobby)
    {
        Player player = lobby.getPlayerOne();
        lobby = lobbyRepository.UpdatePlayerDeck(lobby, player);
        return lobbyContainerRepository.GetLobbyById(lobby.getId());
    }

    @PutMapping(value = "/updateStatus", consumes = "application/json", produces = "application/json")
    public boolean UpdatePlayerStatus(@RequestBody Lobby lobby)
    {
        Player player = lobby.getPlayerOne();
        return lobbyRepository.UpdatePlayerStatus(lobby, player);
    }
}
