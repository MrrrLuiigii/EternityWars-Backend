package com.eternitywars.api.DAL.Repositories.Deck;

import com.eternitywars.api.Factories.Deck.DeckContainerFactory;
import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.Deck;
import com.eternitywars.api.Models.Decks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckContainerRepositoryTest {

    private DeckContainerRepository deckContainerRepository = new DeckContainerRepository(new DeckContainerFactory());

    private int deckToDeleteId;

    private Decks SetupGetDeckByUserId() {
        Decks userOneDecks = new Decks();

        Deck userOneDeckOne = new Deck();
        userOneDeckOne.setDeckId(1);
        userOneDeckOne.setUserId(1);
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
        userOneDeckTwo.setUserId(1);
        userOneDeckTwo.setName("getByUserIdDeckTwo");

        return userOneDecks;
    }

    private Deck SetupGetDeckById()
    {
        Deck deck = new Deck();
        deck.setDeckId(1);
        deck.setUserId(1);
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
        deck.setUserId(1);
        deck.setName("deckToAddAndDelete");
        return deck;
    }

    @Test
    void addDeck() {
        Deck expectedDeck = SetupDeckToAddAndDelete();

        Deck deck = deckContainerRepository.AddDeck(expectedDeck);
        this.deckToDeleteId = deck.getDeckId();

        assertEquals(expectedDeck.getName(), deck.getName());
        assertEquals(expectedDeck.getUserId(), deck.getUserId());

        deleteDeck();
    }

    @Test
    void deleteDeck() {
        Deck deck = new Deck();
        deck.setDeckId(deckToDeleteId);

        boolean result = deckContainerRepository.DeleteDeck(deck);

        assertTrue(result);
    }

    @Test
    void getEmptyDecksByUserId() {
        Decks expectedDecks = SetupGetDeckByUserId();

        Decks decks = deckContainerRepository.GetEmptyDecksByUserId(1);

        for (int i = 0; i < expectedDecks.getDecks().size(); i++)
        {
            assertEquals(expectedDecks.getDecks().get(i).getDeckId(), decks.getDecks().get(i).getDeckId());
            assertEquals(expectedDecks.getDecks().get(i).getUserId(), decks.getDecks().get(i).getUserId());
            assertEquals(expectedDecks.getDecks().get(i).getName(), decks.getDecks().get(i).getName());
        }
    }

    @Test
    void getEmptyDeckById() {
        Deck expectedDeck = SetupGetDeckById();

        Deck deck = deckContainerRepository.GetEmptyDeckById(expectedDeck.getDeckId());

        assertEquals(expectedDeck.getDeckId(), deck.getDeckId());
        assertEquals(expectedDeck.getUserId(), deck.getUserId());
        assertEquals(expectedDeck.getName(), deck.getName());
    }

    @Test
    void getDecksByUserId() {
        Decks expectedDecks = SetupGetDeckByUserId();

        Decks decks = deckContainerRepository.GetDecksByUserId(1);

        for (int i = 0; i < expectedDecks.getDecks().size(); i++)
        {
            assertEquals(expectedDecks.getDecks().get(i).getDeckId(), decks.getDecks().get(i).getDeckId());
            assertEquals(expectedDecks.getDecks().get(i).getUserId(), decks.getDecks().get(i).getUserId());
            assertEquals(expectedDecks.getDecks().get(i).getName(), decks.getDecks().get(i).getName());

            for (int j = 0; j < expectedDecks.getDecks().get(i).getCards().getCards().size(); j++)
            {
                assertEquals(expectedDecks.getDecks().get(i).getCards().getCards().get(j).getCardId(),
                        decks.getDecks().get(i).getCards().getCards().get(j).getCardId());

                assertEquals(expectedDecks.getDecks().get(i).getCards().getCards().get(j).getAttack(),
                        decks.getDecks().get(i).getCards().getCards().get(j).getAttack());

                assertEquals(expectedDecks.getDecks().get(i).getCards().getCards().get(j).getHealth(),
                        decks.getDecks().get(i).getCards().getCards().get(j).getHealth());

                assertEquals(expectedDecks.getDecks().get(i).getCards().getCards().get(j).getBlue_mana(),
                        decks.getDecks().get(i).getCards().getCards().get(j).getBlue_mana());

                assertEquals(expectedDecks.getDecks().get(i).getCards().getCards().get(j).getDeath_essence(),
                        decks.getDecks().get(i).getCards().getCards().get(j).getDeath_essence());

                assertEquals(expectedDecks.getDecks().get(i).getCards().getCards().get(j).getTaunt(),
                        decks.getDecks().get(i).getCards().getCards().get(j).getTaunt());

                assertEquals(expectedDecks.getDecks().get(i).getCards().getCards().get(j).getName(),
                        decks.getDecks().get(i).getCards().getCards().get(j).getName());
            }
        }
    }

    @Test
    void getDeckById() {
        Deck expectedDeck = SetupGetDeckById();

        Deck deck = deckContainerRepository.GetDeckById(expectedDeck.getDeckId());

        assertEquals(expectedDeck.getDeckId(), deck.getDeckId());
        assertEquals(expectedDeck.getUserId(), deck.getUserId());
        assertEquals(expectedDeck.getName(), deck.getName());

        for (int i = 0; i < expectedDeck.getCards().getCards().size(); i++)
        {
            assertEquals(expectedDeck.getCards().getCards().get(i).getCardId(), deck.getCards().getCards().get(i).getCardId());
            assertEquals(expectedDeck.getCards().getCards().get(i).getName(), deck.getCards().getCards().get(i).getName());
            assertEquals(expectedDeck.getCards().getCards().get(i).getAttack(), deck.getCards().getCards().get(i).getAttack());
            assertEquals(expectedDeck.getCards().getCards().get(i).getHealth(), deck.getCards().getCards().get(i).getHealth());
            assertEquals(expectedDeck.getCards().getCards().get(i).getBlue_mana(), deck.getCards().getCards().get(i).getBlue_mana());
            assertEquals(expectedDeck.getCards().getCards().get(i).getDeath_essence(), deck.getCards().getCards().get(i).getDeath_essence());
            assertEquals(expectedDeck.getCards().getCards().get(i).getTaunt(), deck.getCards().getCards().get(i).getTaunt());
        }
    }
}