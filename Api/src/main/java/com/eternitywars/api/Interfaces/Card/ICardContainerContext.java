package com.eternitywars.api.Interfaces.Card;

import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.User;

public interface ICardContainerContext
{
    Cards GetCards();

    Cards GetCardsByUser(int userId);

    Card GetCardById(int cardId);

    boolean AddCard(User user, Card card);

    boolean DeleteCard(User user, Card card);
}
