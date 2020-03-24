package com.eternitywars.api.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @OneToMany
    @JoinTable(name = "chat_user", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users;

    @JsonIgnore
    @OneToMany
    @JoinTable(name = "chat_message", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "message_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
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
