package com.eternitywars.api.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User sender;

    @Column(name = "body", nullable = false, unique = true, length = 64)
    private String body;

    @ManyToOne
    private Chat chat;

    public int getId()
    {
        return id;
    }

    public void setId(int messageId)
    {
        this.id = messageId;
    }

    public User getSender()
    {
        return sender;
    }

    public void setSender(User sender)
    {
        this.sender = sender;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public Chat getChat()
    {
        return chat;
    }

    public void setChat(Chat chat)
    {
        this.chat = chat;
    }
}
