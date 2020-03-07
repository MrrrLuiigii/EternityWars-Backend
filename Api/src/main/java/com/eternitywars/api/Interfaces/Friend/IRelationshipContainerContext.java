package com.eternitywars.api.Interfaces.Friend;

import com.eternitywars.api.Models.Entities.Relationship;
import com.eternitywars.api.Models.Relationships;
import com.eternitywars.api.Models.Entities.User;

public interface IRelationshipContainerContext
{
    boolean AddRelationship(Relationship relationship);

    boolean DeleteRelationship(Relationship relationship);

    Relationships GetRelationships(User user);
}
