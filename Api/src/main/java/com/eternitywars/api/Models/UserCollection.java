package com.eternitywars.api.Models;

import java.util.ArrayList;
import java.util.List;

public class UserCollection
{
    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;

    public UserCollection()
    {
        users = new ArrayList<>();
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void addUser(User user)
    {
        users.add(user);
    }
}
