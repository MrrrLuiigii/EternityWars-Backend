package com.eternitywars.api.Models.Entities;

import com.eternitywars.api.Models.Enums.FriendStatus;

import javax.persistence.*;

@Entity
@Table(name = "friend")
public class Relationship
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "user_one_id", nullable = false, referencedColumnName = "id")
    private User friendOne;

    @ManyToOne()
    @JoinColumn(name = "user_two_id", nullable = false, referencedColumnName = "id")
    private User friendTwo;

    @Column(name = "status", nullable = false)
    private FriendStatus friendStatus;


    public Relationship()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public User getFriendOne()
    {
        return friendOne;
    }

    public void setFriendOne(User friendOne)
    {
        this.friendOne = friendOne;
    }

    public User getFriendTwo()
    {
        return friendTwo;
    }

    public void setFriendTwo(User friendTwo)
    {
        this.friendTwo = friendTwo;
    }

    public FriendStatus getFriendStatus()
    {
        return friendStatus;
    }

    public void setFriendStatus(FriendStatus friendStatus)
    {
        this.friendStatus = friendStatus;
    }
}
