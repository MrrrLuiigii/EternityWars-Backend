package com.eternitywars.api.DAL.Contexts.Card;

import com.eternitywars.api.Interfaces.Card.ICardContainerContext;
import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.CardCollection;
import com.eternitywars.api.Models.User;

public class CardContainerHibernateContext implements ICardContainerContext {
    @Override
    public CardCollection GetCards() {
        return null;
    }

    @Override
    public CardCollection GetCardsByUser(int userId) {
        return null;
    }

    @Override
    public Card GetCardById(int cardId) {
        return null;
    }

    @Override
    public boolean AddCard(User user, Card card) {
        return false;
    }

    @Override
    public boolean DeleteCard(User user, Card card) {
        return false;
    }
}
