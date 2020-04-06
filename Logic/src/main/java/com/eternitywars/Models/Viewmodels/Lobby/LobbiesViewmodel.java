package com.eternitywars.Models.Viewmodels.Lobby;

import java.util.ArrayList;
import java.util.List;

public class LobbiesViewmodel
{
    private List<LobbyViewmodel> lobbies;

    public LobbiesViewmodel()
    {
        this.lobbies = new ArrayList<>();
    }

    public List<LobbyViewmodel> getLobbies()
    {
        return lobbies;
    }

    public void setLobbies(List<LobbyViewmodel> lobbies)
    {
        this.lobbies = lobbies;
    }
}
