package com.eternitywars.api.Models;

import com.eternitywars.api.Models.Entities.Friend;

import java.util.List;

public class Friends
{
    private List<Friend> friends;

    public Friends(){}

    public Friends(List<Friend> friends)
    {
        this.friends = friends;
    }

    public List<Friend> getFriends()
    {
        return friends;
    }

    public void setFriends(List<Friend> friends)
    {
        this.friends = friends;
    }
}
