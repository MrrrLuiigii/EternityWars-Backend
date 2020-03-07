package com.eternitywars.api.Models.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "card")
public class Card
{
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, updatable = false)
    private int cardId;

    @Column(name = "name", nullable = false, unique = true, length = 64)
    private String name;

    @Column(name = "health", nullable = false)
    private int health;

    @Column(name = "attack", nullable = false)
    private int attack;

    @Column(name = "blue_mana", nullable = false)
    private int blue_mana;

    @Column(name = "death_essence", nullable = false)
    private int death_essence;

    @Column(name = "taunt", nullable = false)
    private boolean taunt;


    public Card()
    {
    }

    public Card(int cardId)
    {
        this.cardId = cardId;
    }

    public int getCardId()
    {
        return cardId;
    }

    public void setCardId(int cardId)
    {
        this.cardId = cardId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public int getBlue_mana()
    {
        return blue_mana;
    }

    public void setBlue_mana(int blue_mana)
    {
        this.blue_mana = blue_mana;
    }

    public int getDeath_essence()
    {
        return death_essence;
    }

    public void setDeath_essence(int death_essence)
    {
        this.death_essence = death_essence;
    }

    public boolean getTaunt()
    {
        return taunt;
    }

    public void setTaunt(boolean taunt)
    {
        this.taunt = taunt;
    }
}