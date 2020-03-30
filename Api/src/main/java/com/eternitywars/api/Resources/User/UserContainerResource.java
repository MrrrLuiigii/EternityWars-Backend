package com.eternitywars.api.Resources.User;

import com.eternitywars.api.DAL.Repositories.User.UserContainerRepository;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.AccountStatus;
import com.eternitywars.api.Models.Users;
import com.eternitywars.api.Models.Viewmodels.UserViewmodel;
import com.eternitywars.api.Models.Viewmodels.UsersViewmodel;
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
    public UsersViewmodel GetUsers()
    {
        Users users = userContainerRepository.GetUsers();

        UsersViewmodel usersViewmodel = new UsersViewmodel();

        for (User u : users.getUsers())
        {
            UserViewmodel uvm = new UserViewmodel(
                    u.getUserId(),
                    u.getUsername(),
                    u.getEmail()
            );

            usersViewmodel.getUserViewmodels().add(uvm);
        }

        return usersViewmodel;
    }
}
