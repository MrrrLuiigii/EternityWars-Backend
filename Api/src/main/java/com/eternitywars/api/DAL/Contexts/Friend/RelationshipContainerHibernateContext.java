package com.eternitywars.api.DAL.Contexts.Friend;

import com.eternitywars.api.Interfaces.Friend.IRelationshipContainerContext;
import com.eternitywars.api.Models.Relationship;
import com.eternitywars.api.Models.RelationshipCollection;
import com.eternitywars.api.Models.User;

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
    public RelationshipCollection GetRelationships(User user) {
        return null;
    }
}
