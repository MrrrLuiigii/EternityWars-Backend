package com.eternitywars.api.Interfaces.Lobby;

import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.Player;

public interface ILobbyContext
{
    boolean JoinLobby(Lobby lobby);

    boolean LeaveLobby(Lobby lobby, Player player);

    boolean UpdatePlayerStatus(Lobby lobby, Player player);

    Lobby UpdatePlayerDeck(Lobby lobby, Player player);
}
