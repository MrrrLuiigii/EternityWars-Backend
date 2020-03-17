package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Entities.User;

import javax.persistence.*;

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

    public int getMessage_id() {
        return messageId;
    }

    public void setMessage_id(int message_id) {
        this.messageId = message_id;
    }
}
