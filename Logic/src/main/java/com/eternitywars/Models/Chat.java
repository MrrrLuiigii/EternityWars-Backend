package com.eternitywars.Models;


import java.util.List;

public class Chat
{
    private int chatId;
    private List<User> users;
    private List<Message> messages;

    public Chat()
    {
    }

    public Chat(int chatId, List<User> users, List<Message> messages)
    {
        this.chatId = chatId;
        this.users = users;
        this.messages = messages;
    }

    public int getChatId()
    {
        return chatId;
    }

    public void setChatId(int chatId)
    {
        this.chatId = chatId;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    public List<Message> getMessages()
    {
        return messages;
    }

    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }
}
