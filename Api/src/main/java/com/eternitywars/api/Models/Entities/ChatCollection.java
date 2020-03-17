package com.eternitywars.api.Models.Entities;


import java.util.List;

public class ChatCollection
{
    List<Chat> chats;

    public ChatCollection()
    {
    }

    public ChatCollection(List<Chat> chats)
    {
        this.chats = chats;
    }

    public List<Chat> getChats()
    {
        return chats;
    }

    public void setChats(List<Chat> chats)
    {
        this.chats = chats;
    }
}
