package com.eternitywars.api;

import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Entities.Lobby;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.AccountStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PostmanTest
{
    private static SessionFactory sessionFactory = ApiApplication.testSessionFactory;

    private Session session;
    private Transaction transaction;

    public boolean PrepareEntities()
    {
        User user = new User(
                "MrrrLuiigii",
                "nicky.janse.nj@gmail.com",
                AccountStatus.Online, 200, 4
        );

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
        user.setCardCollection(cardCollection);

        List<Card> cardsInFirstDeck = new ArrayList<>();
        cardsInFirstDeck.add(cardOne);
        cardsInFirstDeck.add(cardTwo);

        Deck firstDeck = new Deck("MyFirstDeck");
        firstDeck.setCards(cardsInFirstDeck);
        firstDeck.setUser(user);

        List<Card> cardsInSecondDeck = new ArrayList<>();
        cardsInSecondDeck.add(cardThree);
        cardsInSecondDeck.add(cardFour);

        Deck secondDeck = new Deck("MySecondDeck");
        secondDeck.setCards(cardsInSecondDeck);
        secondDeck.setUser(user);

        List<Deck> decks = new ArrayList<>();
        decks.add(firstDeck);
        decks.add(secondDeck);
        user.setDecks(decks);

        Lobby lobby = new Lobby();

        return PersistEntities(cardCollection, decks, user);
    }

    private boolean PersistEntities(List<Card> cards, List<Deck> decks, User user)
    {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            for (Card c : cards)
            {
                session.persist(c);
            }

            session.persist(user);

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
            return false;
        } finally
        {
            session.close();
        }

        return true;
    }
}