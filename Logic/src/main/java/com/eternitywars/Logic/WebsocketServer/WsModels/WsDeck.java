package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.Deck;
import com.eternitywars.Models.User;

public class WsDeck {
    WsFrontendUser parameter;
    String token;
    Deck deck;

    public WsDeck() {
    }

    public WsFrontendUser getUser() {
        return parameter;
    }

    public void setUser(WsFrontendUser user) {
        this.parameter = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
