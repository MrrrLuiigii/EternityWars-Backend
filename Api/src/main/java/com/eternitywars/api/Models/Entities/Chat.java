package com.eternitywars.api.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat
{
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, updatable = false)
    private int chatId;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "message", fetch = FetchType.EAGER)
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
