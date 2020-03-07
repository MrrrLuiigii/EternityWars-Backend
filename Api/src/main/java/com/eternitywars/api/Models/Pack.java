package com.eternitywars.api.Models;

import com.eternitywars.api.Models.Entities.Card;

import java.util.List;

public class Pack
{
    List<Card> Card;

    public Pack(List<com.eternitywars.api.Models.Entities.Card> card)
    {
        Card = card;
    }
}
