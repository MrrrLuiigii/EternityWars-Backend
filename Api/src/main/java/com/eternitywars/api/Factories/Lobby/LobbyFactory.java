package com.eternitywars.api.Factories.Lobby;

import com.eternitywars.api.DAL.Contexts.Lobby.LobbyHibernateContext;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContext;

public class LobbyFactory
{
    public static ILobbyContext getLobbyHibernateContext()
    {
        return new LobbyHibernateContext();
    }

    public static ILobbyContext getTestLobbyHibernateContext()
    {
        return new LobbyHibernateContext();
    }
}
