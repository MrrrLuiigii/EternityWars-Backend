package com.eternitywars.api.DAL.Contexts;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Models.Entities.*;
import com.eternitywars.api.Models.Enums.AccountStatus;
import com.eternitywars.api.Models.Enums.FriendStatus;
import com.eternitywars.api.Models.Enums.LobbyPlayerStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PostmanTestContext
{
    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;

    public void PrepareEntities()
    {
        //
        // CARD
        //

        Card cardOne = new Card(
                "Dreadlord von Reemer",
                8, 5, 4, 2, true
        );

        Card cardTwo = new Card(
                "Friday",
                4, 4, 4, 0, false
        );

        Card cardThree = new Card(
                "Africa",
                12, 4, 8, 1, false
        );

        Card cardFour = new Card(
                "FedEx",
                1, 6, 3, 0, false
        );

        List<Card> cardCollection = new ArrayList<>();
        cardCollection.add(cardOne);
        cardCollection.add(cardTwo);
        cardCollection.add(cardThree);
        cardCollection.add(cardFour);

        PersistCard(cardCollection);

        //
        // USER
        //


        User userOne = new User(
                "MrrrLuiigii",
                "nicky.janse.nj@gmail.com",
                AccountStatus.Online, 200, 4
        );
        userOne.setCardCollection(cardCollection);

        userOne = PersistUser(userOne);

        User userTwo = new User(
                "Ruljo026",
                "mario.hendriks@gmail.com",
                AccountStatus.Online, 300, 2
        );
        userTwo.setCardCollection(cardCollection);

        userTwo = PersistUser(userTwo);

        //
        // FRIEND
        //

        Relationship relationship = new Relationship(
                userOne, userTwo, FriendStatus.Accepted
        );

        PersistFriend(relationship);

        //
        // DECK
        //

        List<Card> cardsInFirstDeck = new ArrayList<>();
        cardsInFirstDeck.add(cardOne);
        cardsInFirstDeck.add(cardTwo);

        Deck firstDeck = new Deck("MyFirstDeck");
        firstDeck.setCards(cardsInFirstDeck);
        firstDeck.setUser(userOne);

        List<Card> cardsInSecondDeck = new ArrayList<>();
        cardsInSecondDeck.add(cardThree);
        cardsInSecondDeck.add(cardFour);

        Deck secondDeck = new Deck("MySecondDeck");
        secondDeck.setCards(cardsInSecondDeck);
        secondDeck.setUser(userOne);

        List<Deck> decks = new ArrayList<>();
        decks.add(firstDeck);
        decks.add(secondDeck);
        userOne.setDecks(decks);

        PersistDeck(decks);

        //
        // LOBBY
        //

        Lobby lobby = new Lobby(
                "CoolLobby",
                "This is a cool lobby for testing purposes!",
                false
        );

        PersistLobby(lobby);

        Player player = new Player(userOne, LobbyPlayerStatus.NotReady, null);
        player.setLobby(lobby);

        List<Player> players = new ArrayList<>();
        players.add(player);
        lobby.setPlayers(players);

        PersistPlayer(player);
    }

    private void PersistCard(List<Card> cards)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            for (Card c : cards)
            {
                session.persist(c);
            }

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
    }

    private User PersistUser(User user)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            int id = (int) session.save(user);
            user.setUserId(id);

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

        return user;
    }

    private void PersistFriend(Relationship relationship)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(relationship);

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
    }

    private void PersistDeck(List<Deck> decks)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            for (Deck d : decks)
            {
                session.persist(d);
            }

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
    }

    private void PersistLobby(Lobby lobby)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

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
    }

    private void PersistPlayer(Player player)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(player);

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
    }
}