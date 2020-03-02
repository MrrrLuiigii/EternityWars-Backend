package com.eternitywars.api.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card
{
    @Id
    @Column(name = "id", unique = true)
    private int cardId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "health")
    private int health;

    @Column(name = "attack")
    private int attack;

    @Column(name = "blue_mana")
    private int blue_mana;

    @Column(name = "death_essence")
    private int death_essence;

    @Column(name = "taunt")
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

    public boolean getTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }
}