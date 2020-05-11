package com.eternitywars.api.DAL.Contexts.Lobby;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Lobby.ILobbyContext;
import com.eternitywars.api.Models.DTO.JoinLobbyDTO;
import com.eternitywars.api.Models.Entities.Deck;
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
    public Lobby JoinLobby(JoinLobbyDTO lobby)
    {
        Lobby returnLobby = null;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Lobby getLobby = session.find(Lobby.class, lobby.getLobbyID());
            User user = session.find(User.class, lobby.getPlayerID());
            Player player = new Player(user, LobbyPlayerStatus.NotReady, null);
            player.setLobby(getLobby);
            player.setId((int)session.save(player));
            transaction.commit();
            getLobby.getPlayers().add(player);
            returnLobby = getLobby;
        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }
        return returnLobby;
    }

    @Override
    public boolean LeaveLobby(Lobby lobby, Player player)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            int index = FindUserIndex(lobby, player);
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

            Lobby getLobby = session.find(Lobby.class, lobby.getId());

            int index = FindUserIndex(getLobby, player);
            getLobby.getPlayers().get(index).setLobbyPlayerStatus(player.getLobbyPlayerStatus());

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
    public boolean UpdatePlayerDeck(Lobby lobby, Player playerToFind)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Lobby getLobby = session.find(Lobby.class, lobby.getId());
            Deck deckToFind = playerToFind.getSelectedDeck();

            int playerIndex = FindUserIndex(getLobby, playerToFind);
            Player player = getLobby.getPlayers().get(playerIndex);

            int deckIndex = FindDeckIndex(player, deckToFind);
            Deck deck = player.getUser().getDecks().get(deckIndex);
            player.setSelectedDeck(deck);

            getLobby.getPlayers().set(playerIndex, player);
            player.setLobby(getLobby);

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

    private int FindUserIndex(Lobby lobby, Player player)
    {
        if (lobby.getPlayers().get(0) != null)
        {
            if (lobby.getPlayers().get(0).getId() == player.getId())
            {
                return 0;
            }
        }
        if (lobby.getPlayers().get(1) != null)
        {
            if (lobby.getPlayers().get(1).getId() == player.getId())
            {
                return 1;
            }
        }
        return 0;
    }

    private int FindDeckIndex(Player player, Deck deck)
    {
        int indexCounter = 0;

        for (Deck d : player.getUser().getDecks())
        {
            if (d.getDeckId() == deck.getDeckId())
            {
                break;
            }

            indexCounter++;
        }

        return indexCounter;
    }
}
