package com.eternitywars.api.Models.Viewmodels.Lobby;

import com.eternitywars.api.Models.Decks;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Enums.LobbyPlayerStatus;

import java.util.List;

public class PlayerViewmodel
{
    private int playerId;
    private String username;
    private List<Deck> decks;
    private LobbyPlayerStatus lobbyPlayerStatus;
    private Deck selectedDeck;

    public PlayerViewmodel(int playerId, String username, List<Deck> decks, LobbyPlayerStatus lobbyPlayerStatus, Deck selectedDeck)
    {
        this.playerId = playerId;
        this.username = username;
        this.decks = decks;
        this.lobbyPlayerStatus = lobbyPlayerStatus;
        this.selectedDeck = selectedDeck;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public List<Deck> getDecks()
    {
        return decks;
    }

    public void setDecks(List<Deck> decks)
    {
        this.decks = decks;
    }

    public LobbyPlayerStatus getLobbyPlayerStatus()
    {
        return lobbyPlayerStatus;
    }

    public void setLobbyPlayerStatus(LobbyPlayerStatus lobbyPlayerStatus)
    {
        this.lobbyPlayerStatus = lobbyPlayerStatus;
    }

    public Deck getSelectedDeck()
    {
        return selectedDeck;
    }

    public void setSelectedDeck(Deck selectedDeck)
    {
        this.selectedDeck = selectedDeck;
    }
}
