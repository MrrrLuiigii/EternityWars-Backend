package com.eternitywars.api.Interfaces.Deck;

import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;

public interface IDeckContext
{
    boolean AddCard(Deck deck, Card card);

    boolean DeleteCard(Deck deck, Card card);

    boolean UpdateDeckName(Deck deck);
}
