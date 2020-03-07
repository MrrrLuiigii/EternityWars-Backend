package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Player;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lobby")
public class Lobby
{
    @Id
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "has_Password")
    private boolean hasPassword;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "lobby_id", fetch = FetchType.EAGER)
    private List<Player> players;

    public Lobby(){}

    public Lobby(int lobbyId, String name, String description, boolean hasPassword, String password)
    {
        this.id = lobbyId;
        this.name = name;
        this.description = description;
        this.hasPassword = hasPassword;
        this.password = password;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean getHasPassword()
    {
        return hasPassword;
    }

    public void setHasPassword(boolean hasPassword)
    {
        this.hasPassword = hasPassword;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }



}
