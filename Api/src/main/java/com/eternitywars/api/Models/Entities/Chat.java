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
    private List<ChatUser> users;

    @JsonIgnore
    @OneToMany(mappedBy = "message", fetch = FetchType.EAGER)
    private List<ChatMessage> messages;

    public Chat()
    {
    }

    public Chat(int chatId, List<ChatUser> users, List<ChatMessage> messages)
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

    public List<ChatUser> getUsers()
    {
        return users;
    }

    public void setUsers(List<ChatUser> users)
    {
        this.users = users;
    }

    public List<ChatMessage> getMessages()
    {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages)
    {
        this.messages = messages;
    }
}
