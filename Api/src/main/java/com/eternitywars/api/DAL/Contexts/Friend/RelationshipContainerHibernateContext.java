package com.eternitywars.api.DAL.Contexts.Friend;

import com.eternitywars.api.Interfaces.Friend.IRelationshipContainerContext;
import com.eternitywars.api.Models.Entities.Relationship;
import com.eternitywars.api.Models.Relationships;
import com.eternitywars.api.Models.Entities.User;

public class RelationshipContainerHibernateContext implements IRelationshipContainerContext {
    @Override
    public boolean AddRelationship(Relationship relationship) {
        return false;
    }

    @Override
    public boolean DeleteRelationship(Relationship relationship) {
        return false;
    }

    @Override
    public Relationships GetRelationships(User user) {
        return null;
    }
}
