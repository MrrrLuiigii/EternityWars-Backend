package com.eternitywars.api.DAL.Contexts.User;

import com.eternitywars.api.Interfaces.User.IUserContainerContext;
import com.eternitywars.api.Models.User;
import com.eternitywars.api.Models.UserCollection;

public class UserContainerHibernateContext implements IUserContainerContext {
    @Override
    public User GetUserById(int userId) {
        return null;
    }

    @Override
    public User GetUserByUsername(String username) {
        return null;
    }

    @Override
    public User GetUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public UserCollection GetUsers() {
        return null;
    }

    @Override
    public User AddUser(User user) {
        return null;
    }

    @Override
    public boolean DeleteUser(User user) {
        return false;
    }
}
