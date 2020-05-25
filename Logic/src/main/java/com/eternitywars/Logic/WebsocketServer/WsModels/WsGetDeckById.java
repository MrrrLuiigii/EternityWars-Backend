package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.Deck;
import com.eternitywars.Models.DeckUserless;

public class WsGetDeckById {

    WsFrontendUser parameter;
    String token;
    DeckUserless deck;

    public WsGetDeckById() {
    }

    public WsFrontendUser getParameter() {
        return parameter;
    }

    public void setParameter(WsFrontendUser parameter) {
        this.parameter = parameter;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DeckUserless getDeckUserless() {
        return deck;
    }

    public void setDeckUserless(DeckUserless deckUserless) {
        this.deck = deckUserless;
    }
}
