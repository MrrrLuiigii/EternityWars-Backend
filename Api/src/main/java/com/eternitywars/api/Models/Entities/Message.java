package com.eternitywars.api.Models.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "message")
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private int messageId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User sender;

    @Column(name = "body", nullable = false, unique = true, length = 64)
    private String body;

    @OneToMany(mappedBy = "message", fetch = FetchType.EAGER)
    private List<ChatMessage> chatMessages;

    public int getMessageId()
    {
        return messageId;
    }

    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
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

    public List<ChatMessage> getChatMessages()
    {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages)
    {
        this.chatMessages = chatMessages;
    }
}
