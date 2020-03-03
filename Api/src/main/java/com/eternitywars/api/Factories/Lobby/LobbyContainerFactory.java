package com.eternitywars.api.Factories.Lobby;

import com.eternitywars.api.DAL.Contexts.Lobby.LobbyContainerHibernateContext;
import com.eternitywars.api.DAL.Contexts.Lobby.LobbyContainerSqlContext;
import com.eternitywars.api.Database.DatabaseConnection;
import com.eternitywars.api.Database.TestDatabaseConnection;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContainerContext;

public class LobbyContainerFactory
{
    public static ILobbyContainerContext getLobbyContainerSqlContext()
    {
        return new LobbyContainerSqlContext(new DatabaseConnection());
    }

    public static ILobbyContainerContext getTestLobbyContainerSqlContext()
    {
        return new LobbyContainerSqlContext(new TestDatabaseConnection());
    }

    public static ILobbyContainerContext getLobbyContainerHibernateContext()
    {
        return new LobbyContainerHibernateContext();
    }
}

