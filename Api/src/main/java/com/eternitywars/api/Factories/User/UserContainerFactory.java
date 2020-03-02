package com.eternitywars.api.Factories.User;

import com.eternitywars.api.DAL.Contexts.User.UserContainerHibernateContext;
import com.eternitywars.api.DAL.Contexts.User.UserContainerSqlContext;
import com.eternitywars.api.Database.DatabaseConnection;
import com.eternitywars.api.Database.TestDatabaseConnection;
import com.eternitywars.api.Interfaces.User.IUserContainerContext;

public class UserContainerFactory
{
    public IUserContainerContext getUserContainerSqlContext()
    {
        return new UserContainerSqlContext(new DatabaseConnection());
    }

    public IUserContainerContext getTestUserContainerSqlContext()
    {
        return new UserContainerSqlContext(new TestDatabaseConnection());
    }

    public IUserContainerContext getUserContainerHibernate()
    {
        return new UserContainerHibernateContext();
    }
}
