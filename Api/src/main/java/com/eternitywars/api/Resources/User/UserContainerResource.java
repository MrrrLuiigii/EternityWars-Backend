package com.eternitywars.api.Resources.User;

import com.eternitywars.api.DAL.Repositories.User.UserContainerRepository;
import com.eternitywars.api.Factories.User.UserContainerFactory;
import com.eternitywars.api.Models.User;
import com.eternitywars.api.Models.Users;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public/user")
public class UserContainerResource
{
    private UserContainerRepository userContainerRepository = new UserContainerRepository(UserContainerFactory.getUserContainerHibernate());

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public User AddUser(@RequestBody User user)
    {
        return userContainerRepository.AddUser(user);
    }

    @GetMapping(value = "/getById/{userId}")
    public User GetUserById(@PathVariable("userId") int userId)
    {
        return userContainerRepository.GetUserById(userId);
    }

    @GetMapping(value = "/getByEmail/{email}")
    public User GetUserByEmail(@PathVariable("email") String email)
    {
        return userContainerRepository.GetUserByEmail(email);
    }

    @GetMapping(value = "/getByUsername/{username}")
    public User GetUserByUsername(@PathVariable("username") String username)
    {
        return userContainerRepository.GetUserByUsername(username);
    }

    @GetMapping(value = "/get")
    public Users GetUsers()
    {
        return userContainerRepository.GetUsers();
    }
}
