package com.eternitywars.api.DAL.Contexts.Lobby;

import com.eternitywars.api.Interfaces.Lobby.ILobbyContainerContext;
import com.eternitywars.api.Models.Lobby;
import com.eternitywars.api.Models.LobbyCollection;

public class LobbyContainerHibernateContext implements ILobbyContainerContext {
    @Override
    public Lobby AddLobby(Lobby lobby) {
        return null;
    }

    @Override
    public boolean DeleteLobby(Lobby lobby) {
        return false;
    }

    @Override
    public Lobby GetLobbyById(int lobbyId) {
        return null;
    }

    @Override
    public LobbyCollection GetLobbies() {
        return null;
    }
}
