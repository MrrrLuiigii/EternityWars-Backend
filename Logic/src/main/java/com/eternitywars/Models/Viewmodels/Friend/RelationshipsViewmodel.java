package com.eternitywars.Models.Viewmodels.Friend;

import java.util.ArrayList;
import java.util.List;

public class RelationshipsViewmodel
{
    private List<RelationshipViewmodel> relationships;

    public RelationshipsViewmodel()
    {
        this.relationships = new ArrayList<>();
    }

    public List<RelationshipViewmodel> getRelationships()
    {
        return relationships;
    }

    public void setRelationships(List<RelationshipViewmodel> relationships)
    {
        this.relationships = relationships;
    }
}
