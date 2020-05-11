package com.eternitywars.api.Resources.Lobby;

import com.eternitywars.api.DAL.Repositories.Lobby.LobbyContainerRepository;
import com.eternitywars.api.DAL.Repositories.User.UserContainerRepository;
import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.Player;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.LobbyPlayerStatus;
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
    private UserContainerRepository userContainerRepository = new UserContainerRepository();


    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public LobbyViewmodel AddLobby(@RequestBody Lobby lobby)
    {
        lobby.getPlayers().get(0).setLobbyPlayerStatus(LobbyPlayerStatus.NotReady);
        User user = userContainerRepository.GetUserByUsername(lobby.getPlayers().get(0).getUser().getUsername());
        lobby.getPlayers().get(0).setUser(user);
        Lobby getLobby = lobbyContainerRepository.AddLobby(lobby);
        return FillLobbyViewmodel(getLobby);
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
        return FillLobbyViewmodel(getLobby);
    }

    @GetMapping(value = "/get")
    public LobbiesViewmodel GetLobbies()
    {
        Lobbies getLobbies = lobbyContainerRepository.GetLobbies();

        LobbiesViewmodel lobbies = new LobbiesViewmodel();

        for (Lobby l : getLobbies.getLobbies())
        {
            LobbyViewmodel lobby = FillLobbyViewmodel(l);
            lobbies.getLobbies().add(lobby);
        }

        return lobbies;
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
