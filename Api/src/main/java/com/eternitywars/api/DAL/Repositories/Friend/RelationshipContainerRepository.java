package com.eternitywars.api.DAL.Repositories.Friend;

import com.eternitywars.api.Factories.Friend.RelationshipContainerFactory;
import com.eternitywars.api.Interfaces.Friend.IRelationshipContainerContext;
import com.eternitywars.api.Models.Relationship;
import com.eternitywars.api.Models.Relationships;
import com.eternitywars.api.Models.User;

public class RelationshipContainerRepository implements IRelationshipContainerContext
{
    private IRelationshipContainerContext relationshipContainerContext;

    public RelationshipContainerRepository()
    {
        this.relationshipContainerContext = RelationshipContainerFactory.getRelationshipContainerHibernateContext();
    }

    public RelationshipContainerRepository(IRelationshipContainerContext relationshipContainerContext)
    {
        this.relationshipContainerContext = relationshipContainerContext;
    }


    public boolean AddRelationship(Relationship relationship)
    {
        return relationshipContainerContext.AddRelationship(relationship);
    }

    public boolean DeleteRelationship(Relationship relationship)
    {
        return relationshipContainerContext.DeleteRelationship(relationship);
    }

    public Relationships GetRelationships(User user)
    {
        return relationshipContainerContext.GetRelationships(user);
    }
}
