package com.eternitywars.api.DAL.Contexts.Lobby;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContext;
import com.eternitywars.api.Models.DTO.JoinLobbyDTO;
import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.Player;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.LobbyPlayerStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LobbyHibernateContext implements ILobbyContext
{
    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;

    @Override
    public boolean JoinLobby(JoinLobbyDTO lobby)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Lobby getLobby = session.find(Lobby.class, lobby.getLobbyID());
            User user = session.find(User.class, lobby.getPlayerID());
            Player player = new Player(user, LobbyPlayerStatus.NotReady, null);
            player.setLobby(getLobby);

            getLobby.getPlayers().add(player);

            session.merge(getLobby);

            transaction.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        } finally
        {
            session.close();
        }
        return true;
    }

    @Override
    public boolean LeaveLobby(Lobby lobby, Player player)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            int index = FindUserId(lobby, player);
            lobby.getPlayers().remove(index);

            session.persist(lobby);
            transaction.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        } finally
        {
            session.close();
        }
        return true;
    }

    @Override
    public boolean UpdatePlayerStatus(Lobby lobby, Player player)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            int index = FindUserId(lobby, player);
            lobby.getPlayers().set(index, player);

            session.merge(lobby);
            transaction.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        } finally
        {
            session.close();
        }
        return true;
    }

    @Override
    public Lobby UpdatePlayerDeck(Lobby lobby, Player player)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            int index = FindUserId(lobby, player);
            lobby.getPlayers().set(index, player);

            session.persist(lobby);
            transaction.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return lobby;
        } finally
        {
            session.close();
        }
        return lobby;
    }

    private int FindUserId(Lobby lobby, Player player)
    {
        if (lobby.getPlayers().get(0) != null)
        {
            if (lobby.getPlayers().get(0).getUser().getUserId() == player.getUser().getUserId())
            {
                return 0;
            }
        }
        if (lobby.getPlayers().get(1) != null)
        {
            if (lobby.getPlayers().get(1).getUser().getUserId() == player.getUser().getUserId())
            {
                return 1;
            }
        }
        return 0;
    }
}
