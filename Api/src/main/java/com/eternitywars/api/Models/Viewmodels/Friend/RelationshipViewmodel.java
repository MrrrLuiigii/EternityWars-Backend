package com.eternitywars.api.Models.Viewmodels.Friend;

import com.eternitywars.api.Models.Enums.FriendStatus;

public class RelationshipViewmodel
{
    private FriendViewmodel friendOne;
    private FriendViewmodel friendTwo;
    private FriendStatus friendStatus;

    public RelationshipViewmodel(FriendViewmodel friendOne, FriendViewmodel friendTwo, FriendStatus friendStatus)
    {
        this.friendOne = friendOne;
        this.friendTwo = friendTwo;
        this.friendStatus = friendStatus;
    }

    public FriendViewmodel getFriendOne()
    {
        return friendOne;
    }

    public void setFriendOne(FriendViewmodel friendOne)
    {
        this.friendOne = friendOne;
    }

    public FriendViewmodel getFriendTwo()
    {
        return friendTwo;
    }

    public void setFriendTwo(FriendViewmodel friendTwo)
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
