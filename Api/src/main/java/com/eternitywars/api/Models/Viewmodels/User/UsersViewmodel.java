package com.eternitywars.api.Models.Viewmodels.User;

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
}
