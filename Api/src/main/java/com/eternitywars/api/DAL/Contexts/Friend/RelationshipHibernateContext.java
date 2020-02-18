package com.eternitywars.api.DAL.Contexts.Friend;

import com.eternitywars.api.Interfaces.Friend.IRelationshipContext;
import com.eternitywars.api.Models.Relationship;

public class RelationshipHibernateContext implements IRelationshipContext {
    @Override
    public boolean UpdateRelationship(Relationship relationship) {
        return false;
    }
}
