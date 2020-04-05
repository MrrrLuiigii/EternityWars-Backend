package com.eternitywars.api.Resources.Friend;

import com.eternitywars.api.DAL.Repositories.Friend.RelationshipContainerRepository;
import com.eternitywars.api.DAL.Repositories.User.UserContainerRepository;
import com.eternitywars.api.Models.Entities.Relationship;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Relationships;
import com.eternitywars.api.Models.Viewmodels.Friend.FriendViewmodel;
import com.eternitywars.api.Models.Viewmodels.Friend.RelationshipViewmodel;
import com.eternitywars.api.Models.Viewmodels.Friend.RelationshipsViewmodel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public/friend")
public class RelationshipContainerResource
{
    private RelationshipContainerRepository relationshipContainerRepository = new RelationshipContainerRepository();
    private UserContainerRepository userContainerRepository = new UserContainerRepository();


    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public boolean AddRelationship(@RequestBody Relationship relationship)
    {
        User friendTwo = userContainerRepository.GetUserByUsername(relationship.getFriendTwo().getUsername());
        relationship.setFriendTwo(friendTwo);
        return relationshipContainerRepository.AddRelationship(relationship);
    }

    @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeleteRelationship(@RequestBody Relationship relationship)
    {
        return relationshipContainerRepository.DeleteRelationship(relationship);
    }

    @GetMapping(value = "/get/{userId}")
    public RelationshipsViewmodel GetRelationshipByUserId(@PathVariable("userId") int userId)
    {
        User user = new User(userId);
        Relationships getRelationships = relationshipContainerRepository.GetRelationships(user);

        RelationshipsViewmodel relationships = new RelationshipsViewmodel();

        for (Relationship r : getRelationships.getRelationships())
        {
            FriendViewmodel friendOne = new FriendViewmodel(
                    r.getFriendOne().getUserId(),
                    r.getFriendOne().getUsername(),
                    r.getFriendOne().getAccountStatus()
            );

            FriendViewmodel friendTwo = new FriendViewmodel(
                    r.getFriendTwo().getUserId(),
                    r.getFriendTwo().getUsername(),
                    r.getFriendTwo().getAccountStatus()
            );

            RelationshipViewmodel relationship = new RelationshipViewmodel(
                    friendOne,
                    friendTwo,
                    r.getFriendStatus()
            );

            relationships.getRelationships().add(relationship);
        }

        return relationships;
    }
}