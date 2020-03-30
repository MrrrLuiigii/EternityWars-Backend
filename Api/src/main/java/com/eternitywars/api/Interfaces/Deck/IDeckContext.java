package com.eternitywars.api.Interfaces.Deck;

import com.eternitywars.api.Models.Entities.Deck;

public interface IDeckContext
{
    boolean AddCard(Deck deck);

    boolean DeleteCard(Deck deck);

    boolean UpdateDeckName(Deck deck);
}
