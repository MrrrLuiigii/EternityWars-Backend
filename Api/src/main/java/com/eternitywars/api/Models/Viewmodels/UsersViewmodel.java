package com.eternitywars.api.Models.Viewmodels;

import java.util.List;

public class UsersViewmodel
{
    private List<UserViewmodel> userViewmodels;

    public UsersViewmodel()
    {
    }

    public List<UserViewmodel> getUserViewmodels()
    {
        return userViewmodels;
    }

    public void setUserViewmodels(List<UserViewmodel> userViewmodels)
    {
        this.userViewmodels = userViewmodels;
    }
}
