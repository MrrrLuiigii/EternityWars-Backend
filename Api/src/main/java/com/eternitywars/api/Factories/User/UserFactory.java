package com.eternitywars.api.Factories.User;

import com.eternitywars.api.DAL.Contexts.User.UserHibernateContext;
import com.eternitywars.api.Interfaces.User.IUserContext;

public class UserFactory
{
    public static IUserContext getUserHibernateContext()
    {
        return new UserHibernateContext();
    }

    public static IUserContext getTestUserHibernateContext()
    {
        return new UserHibernateContext();
    }
}
