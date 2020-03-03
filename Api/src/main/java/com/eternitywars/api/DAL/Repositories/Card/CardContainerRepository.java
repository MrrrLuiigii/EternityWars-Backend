package com.eternitywars.api.DAL.Repositories.Card;

import com.eternitywars.api.Factories.Card.CardContainerFactory;
import com.eternitywars.api.Interfaces.Card.ICardContainerContext;
import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.User;

public class CardContainerRepository implements ICardContainerContext
{
    private ICardContainerContext cardContainerContext;

    public CardContainerRepository(ICardContainerContext cardContainerContext)
    {
        this.cardContainerContext = cardContainerContext;
    }

    public CardContainerRepository(CardContainerFactory cardContainerFactory)
    {
        this.cardContainerContext = cardContainerFactory.getTestCardContainerSqlContext();
    }



    public Cards GetCards()
    {
        return cardContainerContext.GetCards();
    }

    public Cards GetCardsByUser(int userId)
    {
        return cardContainerContext.GetCardsByUser(userId);
    }

    public Card GetCardById(int cardId)
    {
        return cardContainerContext.GetCardById(cardId);
    }

    public boolean AddCard(User user, Card card)
    {
        return cardContainerContext.AddCard(user, card);
    }

    public boolean DeleteCard(User user, Card card)
    {
        return cardContainerContext.DeleteCard(user, card);
    }
}
