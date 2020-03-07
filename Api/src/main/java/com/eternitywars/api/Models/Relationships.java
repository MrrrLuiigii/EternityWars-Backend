package com.eternitywars.api.Models;

import com.eternitywars.api.Models.Entities.Relationship;

import java.util.ArrayList;
import java.util.List;

public class Relationships
{
    private List<Relationship> relationships;

    public Relationships()
    {
        relationships = new ArrayList<>();
    }

    public Relationships(List<Relationship> relationships)
    {
        this.relationships = relationships;
    }

    public List<Relationship> getRelationships()
    {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships)
    {
        this.relationships = relationships;
    }
}
