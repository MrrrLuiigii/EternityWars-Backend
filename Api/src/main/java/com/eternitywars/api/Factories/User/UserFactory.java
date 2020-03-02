package com.eternitywars.api.Factories.User;

import com.eternitywars.api.DAL.Contexts.User.UserContainerHibernateContext;
import com.eternitywars.api.DAL.Contexts.User.UserHibernateContext;
import com.eternitywars.api.DAL.Contexts.User.UserSqlContext;
import com.eternitywars.api.Database.DatabaseConnection;
import com.eternitywars.api.Database.TestDatabaseConnection;
import com.eternitywars.api.Interfaces.User.IUserContainerContext;
import com.eternitywars.api.Interfaces.User.IUserContext;

public class UserFactory
{
    public IUserContext getUserSqlContext()
    {
        return new UserSqlContext(new DatabaseConnection());
    }

    public IUserContext getTestUserSqlContext()
    {
        return new UserSqlContext(new TestDatabaseConnection());
    }

    public IUserContext getUserHibernateContext()
    {
        return new UserHibernateContext();
    }

}
