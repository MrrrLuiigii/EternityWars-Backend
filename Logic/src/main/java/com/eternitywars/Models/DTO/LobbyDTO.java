package com.eternitywars.Models.DTO;

import com.eternitywars.Logic.WebsocketServer.WsModels.WsFrontendUser;
import com.eternitywars.Models.Player;

import java.util.ArrayList;
import java.util.List;

public class LobbyDTO {

    private int id;

    private String name;

    private String description;

    private boolean hasPassword;

    private String password;

    private List<LobbyPlayerDTO> players;


    public LobbyDTO(){
        players = new ArrayList<>();
    }

    public LobbyDTO(int lobbyId, String name, String description, boolean hasPassword, String password)
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

    public List<LobbyPlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<LobbyPlayerDTO> players) {
        this.players = players;
    }


}
