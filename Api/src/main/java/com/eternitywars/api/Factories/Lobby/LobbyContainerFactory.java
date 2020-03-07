package com.eternitywars.api.Factories.Lobby;

import com.eternitywars.api.DAL.Contexts.Lobby.LobbyContainerHibernateContext;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContainerContext;

public class LobbyContainerFactory
{
    public static ILobbyContainerContext getLobbyContainerHibernateContext()
    {
        return new LobbyContainerHibernateContext();
    }

    public static ILobbyContainerContext getTestLobbyContainerHibernateContext()
    {
        return new LobbyContainerHibernateContext();
    }
}

