package com.eternitywars.api.DAL.Contexts.Lobby;

import com.eternitywars.api.Interfaces.Lobby.ILobbyContext;
import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.Player;

public class LobbyHibernateContext implements ILobbyContext {
    @Override
    public boolean JoinLobby(Lobby lobby, Player player) {
        return false;
    }

    @Override
    public boolean LeaveLobby(Lobby lobby, Player player) {
        return false;
    }

    @Override
    public boolean UpdatePlayerStatus(Lobby lobby, Player player) {
        return false;
    }

    @Override
    public Lobby UpdatePlayerDeck(Lobby lobby, Player player) {
        return null;
    }
}
