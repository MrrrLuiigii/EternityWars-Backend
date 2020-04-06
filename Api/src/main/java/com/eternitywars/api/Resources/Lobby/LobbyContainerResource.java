package com.eternitywars.api.Resources.Lobby;

import com.eternitywars.api.DAL.Repositories.Lobby.LobbyContainerRepository;
import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.Player;
import com.eternitywars.api.Models.Lobbies;
import com.eternitywars.api.Models.Viewmodels.Lobby.LobbiesViewmodel;
import com.eternitywars.api.Models.Viewmodels.Lobby.LobbyViewmodel;
import com.eternitywars.api.Models.Viewmodels.Lobby.PlayerViewmodel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/public/lobby")
public class LobbyContainerResource
{
    private LobbyContainerRepository lobbyContainerRepository = new LobbyContainerRepository();


    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public LobbyViewmodel AddLobby(@RequestBody Lobby lobby)
    {
        Lobby getLobby = lobbyContainerRepository.AddLobby(lobby);
        return fillLobbyViewmodel(getLobby);
    }

    @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeleteLobby(@RequestBody Lobby lobby)
    {
        return lobbyContainerRepository.DeleteLobby(lobby);
    }

    @GetMapping(value = "/getById/{lobbyId}")
    public LobbyViewmodel GetLobbyById(@PathVariable("lobbyId") int lobbyId)
    {
        Lobby getLobby = lobbyContainerRepository.GetLobbyById(lobbyId);
        LobbyViewmodel lobby = fillLobbyViewmodel(getLobby);
        return lobby;
    }

    @GetMapping(value = "/get")
    public LobbiesViewmodel GetLobbies()
    {
        Lobbies getLobbies = lobbyContainerRepository.GetLobbies();

        LobbiesViewmodel lobbies = new LobbiesViewmodel();

        for (Lobby l : getLobbies.getLobbies())
        {
            LobbyViewmodel lobby = fillLobbyViewmodel(l);
            lobbies.getLobbies().add(lobby);
        }

        return lobbies;
    }

    private LobbyViewmodel fillLobbyViewmodel(Lobby getLobby)
    {
        List<PlayerViewmodel> players = new ArrayList<>();

        for (Player p : getLobby.getPlayers())
        {
            PlayerViewmodel player = new PlayerViewmodel(
                    p.getId(),
                    p.getUser().getUsername(),
                    p.getUser().getDecks(),
                    p.getLobbyPlayerStatus(),
                    p.getSelectedDeck()
            );

            players.add(player);
        }

        LobbyViewmodel lobby = new LobbyViewmodel(
                getLobby.getId(),
                getLobby.getName(),
                getLobby.getDescription(),
                getLobby.getHasPassword(),
                players
        );

        return lobby;
    }
}
