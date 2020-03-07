package com.eternitywars.api.DAL.Repositories.Friend;

import com.eternitywars.api.DAL.Contexts.Friend.RelationshipHibernateContext;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.FriendStatus;
import com.eternitywars.api.Models.Entities.Relationship;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RelationshipRepositoryTest
{
    private RelationshipRepository relationshipRepository = new RelationshipRepository(new RelationshipHibernateContext());


    @Test
    void updateRelationship()
    {
        Relationship relationship = new Relationship();
        User friend = new User();
        friend.setUserId(5);
        relationship.setFriendOne(friend);
        friend.setUserId(6);
        relationship.setFriendStatus(FriendStatus.Accepted);
        assertEquals(true, relationshipRepository.UpdateRelationship(relationship));
    }

    @AfterAll
    void reset()
    {
        Relationship relationship = new Relationship();
        User friend = new User();
        friend.setUserId(5);
        relationship.setFriendOne(friend);
        friend.setUserId(6);
        relationship.setFriendStatus(FriendStatus.Blocked);
        assertEquals(true, relationshipRepository.UpdateRelationship(relationship));
    }
}