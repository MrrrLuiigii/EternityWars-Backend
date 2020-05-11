package com.eternitywars.api.Interfaces.Lobby;

import com.eternitywars.api.Models.DTO.JoinLobbyDTO;
import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.Player;

public interface ILobbyContext
{
    Lobby JoinLobby(JoinLobbyDTO lobby);

    boolean LeaveLobby(Lobby lobby, Player player);

    boolean UpdatePlayerStatus(Lobby lobby, Player player);

    boolean UpdatePlayerDeck(Lobby lobby, Player player);
}
