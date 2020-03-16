package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Entities.User;

public class Message
{
    User sender;
    String body;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
