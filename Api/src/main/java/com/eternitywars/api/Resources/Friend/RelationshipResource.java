package com.eternitywars.api.Resources.Friend;

import com.eternitywars.api.DAL.Repositories.Friend.RelationshipRepository;
import com.eternitywars.api.Models.Relationship;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/private/friend")
public class RelationshipResource
{
    private RelationshipRepository relationshipRepository = new RelationshipRepository();


    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public boolean UpdateRelationship(@RequestBody Relationship relationship)
    {
        return relationshipRepository.UpdateRelationship(relationship);
    }
}