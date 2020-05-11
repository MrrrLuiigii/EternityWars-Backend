package com.eternitywars.api.Resources.Lobby;

import com.eternitywars.api.DAL.Repositories.Lobby.LobbyContainerRepository;
import com.eternitywars.api.DAL.Repositories.Lobby.LobbyRepository;
import com.eternitywars.api.Models.DTO.JoinLobbyDTO;
import com.eternitywars.api.Models.DTO.UpdateLobbyPlayerStatusDTO;
import com.eternitywars.api.Models.DTO.UpdatePlayerDeckDTO;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.Player;
import com.eternitywars.api.Models.Viewmodels.Lobby.LobbyViewmodel;
import com.eternitywars.api.Models.Viewmodels.Lobby.PlayerViewmodel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/public/lobby")
public class LobbyResource
{
    private LobbyRepository lobbyRepository = new LobbyRepository();
    private LobbyContainerRepository lobbyContainerRepository = new LobbyContainerRepository();


    @PostMapping(value = "/join", consumes = "application/json", produces = "application/json")
    public LobbyViewmodel Join(@RequestBody JoinLobbyDTO lobby)
    {
        Lobby joinedLobby = lobbyRepository.JoinLobby(lobby);
        return FillLobbyViewmodel(joinedLobby);
    }

    @PostMapping(value = "/leave", consumes = "application/json", produces = "application/json")
    public boolean Leave(@RequestBody Lobby lobby)
    {
        return lobbyRepository.LeaveLobby(lobby, lobby.getPlayers().get(0));
    }

    @PutMapping(value = "/updateDeck", consumes = "application/json", produces = "application/json")
    public boolean UpdatePlayerDeck(@RequestBody UpdatePlayerDeckDTO lobbyDTO)
    {
        Lobby lobby = new Lobby();
        lobby.setId(lobbyDTO.getLobbyID());

        Player player = new Player();
        player.setId(lobbyDTO.getPlayerID());
        player.setSelectedDeck(new Deck(lobbyDTO.getPlayerDeckID()));

        return lobbyRepository.UpdatePlayerDeck(lobby, player);
    }

    @PutMapping(value = "/updateStatus", consumes = "application/json", produces = "application/json")
    public boolean UpdatePlayerStatus(@RequestBody UpdateLobbyPlayerStatusDTO lobbyDTO)
    {
        Lobby lobby = new Lobby();
        lobby.setId(lobbyDTO.getLobbyID());

        Player player = new Player();
        player.setId(lobbyDTO.getPlayerID());
        player.setLobbyPlayerStatus(lobbyDTO.getStatus());

        return lobbyRepository.UpdatePlayerStatus(lobby, player);
    }

    private LobbyViewmodel FillLobbyViewmodel(Lobby getLobby)
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

        return new LobbyViewmodel(
                getLobby.getId(),
                getLobby.getName(),
                getLobby.getDescription(),
                getLobby.getHasPassword(),
                players
        );
    }
}
