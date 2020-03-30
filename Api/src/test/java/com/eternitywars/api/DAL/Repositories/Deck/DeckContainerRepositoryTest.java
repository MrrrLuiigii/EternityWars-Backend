package com.eternitywars.api.DAL.Repositories.Deck;

import com.eternitywars.api.DAL.Contexts.Deck.DeckContainerHibernateContext;
import com.eternitywars.api.Models.*;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeckContainerRepositoryTest
{
    private DeckContainerRepository deckContainerRepository = new DeckContainerRepository(new DeckContainerHibernateContext());


    private int deckToDeleteId;

    private Decks SetupGetDeckByUserId()
    {
        Decks userOneDecks = new Decks();

        Deck userOneDeckOne = new Deck();
        userOneDeckOne.setDeckId(1);
        User user = new User();
        user.setUserId(1);
        userOneDeckOne.setUser(user);
        userOneDeckOne.setName("getByUserIdDeckOne");

        Cards deckOneCards = new Cards();
        Card card = new Card();
        card.setCardId(2);
        card.setName("Africa");
        card.setAttack(1);
        card.setHealth(1);
        card.setBlue_mana(1);
        card.setDeath_essence(1);
        card.setTaunt(true);
        deckOneCards.AddCard(card);
        // userOneDeckOne.setCards(deckOneCards);

        Deck userOneDeckTwo = new Deck();
        userOneDeckTwo.setDeckId(2);
        user = new User();
        user.setUserId(1);
        userOneDeckTwo.setUser(user);
        userOneDeckTwo.setName("getByUserIdDeckTwo");

        return userOneDecks;
    }

    private Deck SetupGetDeckById()
    {
        Deck deck = new Deck();
        deck.setDeckId(1);
        User user = new User();
        user.setUserId(1);
        deck.setUser(user);
        deck.setName("getByUserIdDeckOne");

        Cards deckOneCards = new Cards();
        Card card = new Card();
        card.setCardId(2);
        card.setName("Africa");
        card.setAttack(1);
        card.setHealth(1);
        card.setBlue_mana(1);
        card.setDeath_essence(1);
        card.setTaunt(true);
        deckOneCards.AddCard(card);
        // deck.setCards(deckOneCards);

        return deck;
    }

    private Deck SetupDeckToAddAndDelete()
    {
        Deck deck = new Deck();
        deck.setDeckId(3);
        User user = new User();
        user.setUserId(1);
        deck.setUser(user);
        deck.setName("deckToAddAndDelete");
        return deck;
    }

    @Test
    void addDeck()
    {
        Deck expectedDeck = SetupDeckToAddAndDelete();

        Deck deck = deckContainerRepository.AddDeck(expectedDeck);
        this.deckToDeleteId = deck.getDeckId();

        assertEquals(expectedDeck.getName(), deck.getName());
        assertEquals(expectedDeck.getUser().getUserId(), deck.getUser().getUserId());

        deleteDeck();
    }

    @Test
    void deleteDeck()
    {
        Deck deck = new Deck();
        deck.setDeckId(deckToDeleteId);

        boolean result = deckContainerRepository.DeleteDeck(deck);

        assertTrue(result);
    }

    @Test
    void getDecksByUserId()
    {
        Decks expectedDecks = SetupGetDeckByUserId();

        Decks decks = deckContainerRepository.GetDecksByUserId(1);

        for (int i = 0; i < expectedDecks.getDecks().size(); i++)
        {
            assertEquals(expectedDecks.getDecks().get(i).getDeckId(), decks.getDecks().get(i).getDeckId());
            assertEquals(expectedDecks.getDecks().get(i).getUser().getUserId(), decks.getDecks().get(i).getUser().getUserId());
            assertEquals(expectedDecks.getDecks().get(i).getName(), decks.getDecks().get(i).getName());

            for (int j = 0; j < expectedDecks.getDecks().get(i).getCards().size(); j++)
            {
                assertEquals(expectedDecks.getDecks().get(i).getCards().get(j).getCardId(),
                        decks.getDecks().get(i).getCards().get(j).getCardId());

                assertEquals(expectedDecks.getDecks().get(i).getCards().get(j).getAttack(),
                        decks.getDecks().get(i).getCards().get(j).getAttack());

                assertEquals(expectedDecks.getDecks().get(i).getCards().get(j).getHealth(),
                        decks.getDecks().get(i).getCards().get(j).getHealth());

                assertEquals(expectedDecks.getDecks().get(i).getCards().get(j).getBlue_mana(),
                        decks.getDecks().get(i).getCards().get(j).getBlue_mana());

                assertEquals(expectedDecks.getDecks().get(i).getCards().get(j).getDeath_essence(),
                        decks.getDecks().get(i).getCards().get(j).getDeath_essence());

                assertEquals(expectedDecks.getDecks().get(i).getCards().get(j).getTaunt(),
                        decks.getDecks().get(i).getCards().get(j).getTaunt());

                assertEquals(expectedDecks.getDecks().get(i).getCards().get(j).getName(),
                        decks.getDecks().get(i).getCards().get(j).getName());
            }
        }
    }

    @Test
    void getDeckById()
    {
        Deck expectedDeck = SetupGetDeckById();

        Deck deck = deckContainerRepository.GetDeckById(expectedDeck.getDeckId());

        assertEquals(expectedDeck.getDeckId(), deck.getDeckId());
        assertEquals(expectedDeck.getUser().getUserId(), deck.getUser().getUserId());
        assertEquals(expectedDeck.getName(), deck.getName());

        for (int i = 0; i < expectedDeck.getCards().size(); i++)
        {
            assertEquals(expectedDeck.getCards().get(i).getCardId(), deck.getCards().get(i).getCardId());
            assertEquals(expectedDeck.getCards().get(i).getName(), deck.getCards().get(i).getName());
            assertEquals(expectedDeck.getCards().get(i).getAttack(), deck.getCards().get(i).getAttack());
            assertEquals(expectedDeck.getCards().get(i).getHealth(), deck.getCards().get(i).getHealth());
            assertEquals(expectedDeck.getCards().get(i).getBlue_mana(), deck.getCards().get(i).getBlue_mana());
            assertEquals(expectedDeck.getCards().get(i).getDeath_essence(), deck.getCards().get(i).getDeath_essence());
            assertEquals(expectedDeck.getCards().get(i).getTaunt(), deck.getCards().get(i).getTaunt());
        }
    }
}