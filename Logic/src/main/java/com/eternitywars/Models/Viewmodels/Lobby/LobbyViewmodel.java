package com.eternitywars.Models.Viewmodels.Lobby;

import java.util.List;

public class LobbyViewmodel
{
    private int id;
    private String name;
    private String description;
    private boolean hasPassword;
    private List<PlayerViewmodel> players;

    public LobbyViewmodel() {
    }

    public LobbyViewmodel(int id, String name, String description, boolean hasPassword, List<PlayerViewmodel> players)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hasPassword = hasPassword;
        this.players = players;
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

    public boolean isHasPassword()
    {
        return hasPassword;
    }

    public void setHasPassword(boolean hasPassword)
    {
        this.hasPassword = hasPassword;
    }

    public List<PlayerViewmodel> getPlayers()
    {
        return players;
    }

    public void setPlayers(List<PlayerViewmodel> players)
    {
        this.players = players;
    }
}
