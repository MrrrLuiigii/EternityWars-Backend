package com.eternitywars.api.Factories.User;

import com.eternitywars.api.DAL.Contexts.User.UserContainerHibernateContext;
import com.eternitywars.api.Interfaces.User.IUserContainerContext;

public class UserContainerFactory
{
    public static IUserContainerContext getUserContainerHibernateContext()
    {
        return new UserContainerHibernateContext();
    }

    public static IUserContainerContext getTestUserContainerHibernateContext()
    {
        return new UserContainerHibernateContext();
    }
}
