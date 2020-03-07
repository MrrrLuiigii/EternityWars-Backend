package com.eternitywars.api.Resources.Lobby;

import com.eternitywars.api.DAL.Repositories.Lobby.LobbyContainerRepository;
import com.eternitywars.api.DAL.Repositories.Lobby.LobbyRepository;
import com.eternitywars.api.Models.Lobby;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public/lobby")
public class LobbyResource
{
    private LobbyRepository lobbyRepository = new LobbyRepository();
    private LobbyContainerRepository lobbyContainerRepository = new LobbyContainerRepository();


    @PostMapping(value = "/join", consumes = "application/json", produces = "application/json")
    public boolean Join(@RequestBody Lobby lobby)
    {
        return lobbyRepository.JoinLobby(lobby, lobby.getPlayers().get(1));
    }

    @PostMapping(value = "/leave", consumes = "application/json", produces = "application/json")
    public boolean Leave(@RequestBody Lobby lobby)
    {
        return lobbyRepository.LeaveLobby(lobby, lobby.getPlayers().get(0));
    }

    @PutMapping(value = "/updateDeck", consumes = "application/json", produces = "application/json")
    public Lobby UpdatePlayerDeck(@RequestBody Lobby lobby)
    {
        lobby = lobbyRepository.UpdatePlayerDeck(lobby, lobby.getPlayers().get(0));
        return lobbyContainerRepository.GetLobbyById(lobby.getId());
    }

    @PutMapping(value = "/updateStatus", consumes = "application/json", produces = "application/json")
    public boolean UpdatePlayerStatus(@RequestBody Lobby lobby)
    {

        return lobbyRepository.UpdatePlayerStatus(lobby, lobby.getPlayers().get(0));
    }
}
