package com.eternitywars.api.Interfaces.User;

import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Users;

public interface IUserContainerContext
{
    User GetUserById(int userId);

    User GetUserByUsername(String username);

    User GetUserByEmail(String userEmail);

    Users GetUsers();

    User AddUser(User user);

    boolean DeleteUser(User user);
}
