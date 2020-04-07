package com.eternitywars.Models.DTO;

import com.eternitywars.Models.Deck;
import com.eternitywars.Models.Enums.LobbyPlayerStatus;
import com.eternitywars.Models.User;

public class LobbyPlayerDTO {

    private int id;
    private User user;
    private LobbyDTO lobby;
    private LobbyPlayerStatus lobbyPlayerStatus;
    private Deck selectedDeck;


    public LobbyPlayerDTO(User user, LobbyPlayerStatus lobbyPlayerStatus)
    {
        this.user = user;
        this.lobbyPlayerStatus = lobbyPlayerStatus;
    }



    // Getters & Setters


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public void setSelectedDeck(Deck deck)
    {
        this.selectedDeck = deck;
    }

    public LobbyDTO getLobby()
    {
        return lobby;
    }

    public void setLobby(LobbyDTO lobby_id)
    {
        this.lobby = lobby_id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
