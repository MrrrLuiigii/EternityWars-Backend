package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Enums.LobbyPlayerStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "lobby"})
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lobby_id", nullable = false, referencedColumnName = "id")
    private Lobby lobby;

    @Column(name = "lobby_player_status", columnDefinition = "int default 0", nullable = false)
    private LobbyPlayerStatus lobbyPlayerStatus;

    @OneToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "id")
    private Deck selectedDeck;


    public Player()
    {
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

    public Lobby getLobby()
    {
        return lobby;
    }

    public void setLobby(Lobby lobby_id)
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
