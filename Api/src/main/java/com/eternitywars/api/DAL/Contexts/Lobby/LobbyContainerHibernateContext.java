package com.eternitywars.api.DAL.Contexts.Lobby;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContainerContext;
import com.eternitywars.api.Models.Entities.Player;
import com.eternitywars.api.Models.Lobbies;
import com.eternitywars.api.Models.Entities.Lobby;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LobbyContainerHibernateContext implements ILobbyContainerContext {

    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;

    @Override
    public Lobby AddLobby(Lobby lobby) {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            lobby.getPlayers().get(0).setLobby(lobby);
            session.persist(lobby);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }

            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return lobby;
    }

    @Override
    public boolean DeleteLobby(Lobby lobby) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(lobby);
            transaction.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
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
        String hql = "FROM Lobby";

        List<Lobby> lobbies;
        Lobbies lobbiesCollection = new Lobbies();

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<Lobby> typedQuery = session.createQuery(hql, Lobby.class);

            lobbies = typedQuery.getResultList();
            lobbiesCollection.setLobbies(lobbies);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return lobbiesCollection;
    }
}
