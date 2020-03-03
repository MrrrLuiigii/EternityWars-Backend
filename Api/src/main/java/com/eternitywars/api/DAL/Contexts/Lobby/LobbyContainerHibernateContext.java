package com.eternitywars.api.DAL.Contexts.Lobby;

import com.eternitywars.api.Interfaces.Lobby.ILobbyContainerContext;
import com.eternitywars.api.Models.Lobby;
import com.eternitywars.api.Models.LobbyCollection;
import com.eternitywars.api.Models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LobbyContainerHibernateContext implements ILobbyContainerContext {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("eternitywars");
    @Override
    public Lobby AddLobby(Lobby lobby) {
        return null;
    }

    @Override
    public boolean DeleteLobby(Lobby lobby) {
        return false;
    }

    @Override
    public Lobby GetLobbyById(int lobbyId) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        Lobby returnlobby;

        try {
            returnlobby = entityManager.find(Lobby.class, lobbyId);
        } catch (Exception ex) {
            return null;
        } finally {
            entityManager.close();
        }

        return returnlobby;
    }

    @Override
    public LobbyCollection GetLobbies() {
        return null;
    }
}
