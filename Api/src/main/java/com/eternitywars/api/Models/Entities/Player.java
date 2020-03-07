package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Enums.LobbyPlayerStatus;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lobby lobby;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "lobby_player_status")
    private LobbyPlayerStatus lobbyPlayerStatus;

    @OneToOne()
    @JoinColumn(name = "deck_id")
    private Deck deck;


    public Player()
    {
    }

    public Player(int userId, String username, LobbyPlayerStatus lobbyPlayerStatus, int deckId)
    {
        this.user.setUserId(userId);
        this.user.setUsername(username);
        this.lobbyPlayerStatus = lobbyPlayerStatus;
        this.deck = new Deck(deckId);
    }

    // Getters & Setters

    public LobbyPlayerStatus getLobbyPlayerStatus()
    {
        return lobbyPlayerStatus;
    }

    public void setLobbyPlayerStatus(LobbyPlayerStatus lobbyPlayerStatus)
    {
        this.lobbyPlayerStatus = lobbyPlayerStatus;
    }

    public Deck getDeck()
    {
        return deck;
    }

    public void setDeck(Deck deck)
    {
        this.deck = deck;
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
