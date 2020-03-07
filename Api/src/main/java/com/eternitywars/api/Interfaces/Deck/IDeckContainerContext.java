package com.eternitywars.api.Interfaces.Deck;

import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Decks;

public interface IDeckContainerContext
{
    Deck AddDeck(Deck deck);

    boolean DeleteDeck(Deck deck);

    Decks GetEmptyDecksByUserId(int userId);

    Deck GetEmptyDeckById(int deckId);

    Decks GetDecksByUserId(int userId);

    Deck GetDeckById(int deckId);
}
