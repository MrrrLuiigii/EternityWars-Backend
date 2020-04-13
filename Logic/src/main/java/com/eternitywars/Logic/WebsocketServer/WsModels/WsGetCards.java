package com.eternitywars.Logic.WebsocketServer.WsModels;

import com.eternitywars.Models.User;
import com.eternitywars.Models.Viewmodels.SingleUserViewmodel;

public class WsGetCards {
    SingleUserViewmodel parameter;
    String token;

    public WsGetCards() {
    }

    public SingleUserViewmodel getUser() {
        return parameter;
    }

    public void setUser(SingleUserViewmodel user) {
        this.parameter = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
