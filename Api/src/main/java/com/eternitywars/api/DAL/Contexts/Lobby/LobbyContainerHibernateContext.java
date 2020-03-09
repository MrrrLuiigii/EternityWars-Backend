package com.eternitywars.api.DAL.Contexts.Lobby;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContainerContext;
import com.eternitywars.api.Models.Lobbies;
import com.eternitywars.api.Models.Entities.Lobby;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LobbyContainerHibernateContext implements ILobbyContainerContext {

    private static SessionFactory sessionFactory = ApiApplication.getSessionFactory();

    private Session session;
    private Transaction transaction;

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

        Lobby returnlobby;

        try {
            session = sessionFactory.openSession();
            returnlobby = session.find(Lobby.class, lobbyId);
        } catch (Exception ex) {
            return null;
        } finally {
            session.close();
        }

        return returnlobby;
    }

    @Override
    public Lobbies GetLobbies() {
        return null;
    }
}
