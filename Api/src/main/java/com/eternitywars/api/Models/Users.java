package com.eternitywars.api.Models;

import com.eternitywars.api.Models.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class Users
{
    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;

    public Users()
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
