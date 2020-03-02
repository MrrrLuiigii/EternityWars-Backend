package com.eternitywars.api.DAL.Contexts.Card;

import com.eternitywars.api.Interfaces.Card.ICardContainerContext;
import com.eternitywars.api.Models.Card;
import com.eternitywars.api.Models.CardCollection;
import com.eternitywars.api.Models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CardContainerHibernateContext implements ICardContainerContext {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("eternitywars");

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
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        Card card;

        try {
            card = entityManager.find(Card.class, cardId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }

        return card;
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
