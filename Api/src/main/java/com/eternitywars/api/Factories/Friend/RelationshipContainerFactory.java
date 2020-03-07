package com.eternitywars.api.Factories.Friend;

import com.eternitywars.api.DAL.Contexts.Friend.RelationshipContainerHibernateContext;
import com.eternitywars.api.Interfaces.Friend.IRelationshipContainerContext;

public class RelationshipContainerFactory
{
    public static IRelationshipContainerContext getRelationshipContainerHibernateContext()
    {
        return new RelationshipContainerHibernateContext();
    }

    public static IRelationshipContainerContext getTestRelationshipContainerHibernateContext()
    {
        return new RelationshipContainerHibernateContext();
    }
}
