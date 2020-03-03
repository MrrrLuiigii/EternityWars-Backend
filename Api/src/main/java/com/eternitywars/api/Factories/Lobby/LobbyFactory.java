package com.eternitywars.api.Factories.Lobby;

import com.eternitywars.api.DAL.Contexts.Lobby.LobbyHibernateContext;
import com.eternitywars.api.DAL.Contexts.Lobby.LobbySqlContext;
import com.eternitywars.api.Database.DatabaseConnection;
import com.eternitywars.api.Database.TestDatabaseConnection;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContext;

public class LobbyFactory
{
    public static ILobbyContext getLobbySqlContext()
    {
        return new LobbySqlContext(new DatabaseConnection());
    }

    public static ILobbyContext getTestLobbySqlContext()
    {
        return new LobbySqlContext(new TestDatabaseConnection());
    }

    public static ILobbyContext getLobbyHibernateContext()
    {
        return new LobbyHibernateContext();
    }
}
