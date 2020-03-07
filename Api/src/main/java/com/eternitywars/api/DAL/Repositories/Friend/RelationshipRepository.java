package com.eternitywars.api.DAL.Repositories.Friend;

import com.eternitywars.api.Factories.Friend.RelationshipFactory;
import com.eternitywars.api.Interfaces.Friend.IRelationshipContext;
import com.eternitywars.api.Models.Relationship;

public class RelationshipRepository implements IRelationshipContext
{
    private IRelationshipContext relationshipContext;

    public RelationshipRepository()
    {
        this.relationshipContext = RelationshipFactory.getRelationshipHibernateContext();
    }

    public RelationshipRepository(IRelationshipContext relationshipContext)
    {
        this.relationshipContext = relationshipContext;
    }


    public boolean UpdateRelationship(Relationship relationship)
    {
        return relationshipContext.UpdateRelationship(relationship);
    }
}
