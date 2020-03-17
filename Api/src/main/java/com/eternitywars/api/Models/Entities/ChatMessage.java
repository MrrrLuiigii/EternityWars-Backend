package com.eternitywars.api.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "chat_message")
public class ChatMessage
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false, referencedColumnName = "id")
    private Chat chat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false, referencedColumnName = "id")
    private Message message;
}
