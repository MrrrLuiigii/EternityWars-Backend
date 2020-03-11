package com.eternitywars.api.Resources.Friend;

import com.eternitywars.api.DAL.Repositories.Friend.RelationshipContainerRepository;
import com.eternitywars.api.DAL.Repositories.User.UserContainerRepository;
import com.eternitywars.api.Models.Entities.Relationship;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.FriendStatus;
import com.eternitywars.api.Models.Relationships;
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
    public Relationships GetRelationshipByUserId(@PathVariable("userId") int userId)
    {
        User user = new User(userId);
        return relationshipContainerRepository.GetRelationships(user);
    }
}