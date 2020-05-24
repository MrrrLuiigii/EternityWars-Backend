package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.Deck;
import com.eternitywars.Models.User;

public class WsDeck {
    WsFrontendUser user;
    String token;
    Deck deck;

    public WsDeck() {
    }

    public WsFrontendUser getUser() {
        return user;
    }

    public void setUser(WsFrontendUser user) {
        this.user = user;
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
