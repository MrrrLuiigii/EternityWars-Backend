package com.eternitywars.api.DAL.Repositories.User;

import com.eternitywars.api.Factories.User.UserContainerFactory;
import com.eternitywars.api.Interfaces.User.IUserContainerContext;
import com.eternitywars.api.Models.User;
import com.eternitywars.api.Models.Users;

public class UserContainerRepository implements IUserContainerContext
{
    private IUserContainerContext userContainerContext;

    public UserContainerRepository(IUserContainerContext userContainerContext)
    {
        this.userContainerContext = userContainerContext;
    }

    public UserContainerRepository(UserContainerFactory userContainerFactory)
    {
        this.userContainerContext = userContainerFactory.getTestUserContainerSqlContext();
    }



    public User GetUserById(int userId)
    {
        return userContainerContext.GetUserById(userId);
    }

    public User GetUserByUsername(String username)
    {
        return userContainerContext.GetUserByUsername(username);
    }

    public User GetUserByEmail(String userEmail)
    {
        return userContainerContext.GetUserByEmail(userEmail);
    }

    public Users GetUsers()
    {
          return userContainerContext.GetUsers();
    }

    public User AddUser(User user)
    {
        return userContainerContext.AddUser(user);
    }

    public boolean DeleteUser(User user)
    {
        return userContainerContext.DeleteUser(user);
    }

}
