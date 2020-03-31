package com.eternitywars.Models.Viewmodels;

import java.util.ArrayList;
import java.util.List;

public class UsersViewmodel
{
    private List<UserViewmodel> users;

    public UsersViewmodel()
    {
        users = new ArrayList<>();
    }

    public List<UserViewmodel> getUsers()
    {
        return users;
    }

    public void setUsers(List<UserViewmodel> users)
    {
        this.users = users;
    }

    public UsersViewmodel(List<UserViewmodel> users) {
        this.users = users;
    }
}
