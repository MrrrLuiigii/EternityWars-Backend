package com.eternitywars.api.Factories.Friend;

import com.eternitywars.api.DAL.Contexts.Friend.RelationshipHibernateContext;
import com.eternitywars.api.Interfaces.Friend.IRelationshipContext;

public class RelationshipFactory
{
    public static IRelationshipContext getRelationshipHibernateContext()
    {
        return new RelationshipHibernateContext();
    }

    public static IRelationshipContext getTestRelationshipHibernateContext()
    {
        return new RelationshipHibernateContext();
    }
}
