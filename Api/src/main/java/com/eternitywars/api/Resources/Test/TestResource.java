package com.eternitywars.api.Resources.Test;

import com.eternitywars.api.DAL.Contexts.PostmanTestContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/public/test")
public class TestResource
{
    @GetMapping()
    public boolean PrepareTests()
    {
        try
        {
            PostmanTestContext postmanTestContext = new PostmanTestContext();
            postmanTestContext.PrepareEntities();
        } catch (Exception e)
        {
            return false;
        }

        return true;
    }
}
