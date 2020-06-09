package com.eternitywars.Models;

import com.eternitywars.Models.DTO.LobbyDTO;
import com.eternitywars.Models.Viewmodels.Lobby.LobbyViewmodel;
import com.eternitywars.Models.Viewmodels.Lobby.PlayerViewmodel;

import java.util.ArrayList;
import java.util.List;

public class GameConverter
{
    public static Game ConvertToGame(LobbyViewmodel lobby)
    {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(lobby.getPlayers().get(0)));
        players.add(new Player(lobby.getPlayers().get(1)));
        Game game = new Game();
        game.setConnectedPlayers(players);
        game.getConnectedPlayers().get(0).setDeck(lobby.getPlayers().get(0).getSelectedDeck());
        game.getConnectedPlayers().get(1).setDeck(lobby.getPlayers().get(1).getSelectedDeck());
        return game;
    }
}
