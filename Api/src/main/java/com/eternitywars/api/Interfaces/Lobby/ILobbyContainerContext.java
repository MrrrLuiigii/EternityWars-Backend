package com.eternitywars.api.Interfaces.Lobby;

import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Lobbies;

public interface ILobbyContainerContext
{
    Lobby AddLobby(Lobby lobby);

    boolean DeleteLobby(Lobby lobby);

    Lobby GetLobbyById(int lobbyId);

    Lobbies GetLobbies();
}
