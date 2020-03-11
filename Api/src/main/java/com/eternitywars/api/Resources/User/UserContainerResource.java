package com.eternitywars.api.Resources.User;

import com.eternitywars.api.DAL.Repositories.User.UserContainerRepository;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.AccountStatus;
import com.eternitywars.api.Models.Users;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public/user")
public class UserContainerResource
{
    private UserContainerRepository userContainerRepository = new UserContainerRepository();


    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public User AddUser(@RequestBody User user)
    {
        user.setAccountStatus(AccountStatus.Online);
        return userContainerRepository.AddUser(user);
    }

    @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeleteUser(@RequestBody User user)
    {
        return userContainerRepository.DeleteUser(user);
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
