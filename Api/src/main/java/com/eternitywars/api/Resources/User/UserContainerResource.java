package com.eternitywars.api.Resources.User;

import com.eternitywars.api.DAL.Repositories.User.UserContainerRepository;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.AccountStatus;
import com.eternitywars.api.Models.Users;
import com.eternitywars.api.Models.Viewmodels.SingleUserViewmodel;
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
    public SingleUserViewmodel GetUserById(@PathVariable("userId") int userId)
    {
        User user = userContainerRepository.GetUserById(userId);
        return FillSingleUserViewmodel(user);
    }

    @GetMapping(value = "/getByEmail/{email}")
    public SingleUserViewmodel GetUserByEmail(@PathVariable("email") String email)
    {
        User user = userContainerRepository.GetUserByEmail(email);
        return FillSingleUserViewmodel(user);
    }

    @GetMapping(value = "/getByUsername/{username}")
    public SingleUserViewmodel GetUserByUsername(@PathVariable("username") String username)
    {
        User user = userContainerRepository.GetUserByUsername(username);
        return FillSingleUserViewmodel(user);
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
                    u.getEmail(),
                    u.getAccountStatus()
            );

            usersViewmodel.getUsers().add(uvm);
        }

        return usersViewmodel;
    }

    private SingleUserViewmodel FillSingleUserViewmodel(User user)
    {
        return new SingleUserViewmodel(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getAccountStatus(),
                user.getGold(),
                user.getPackAmount()
        );
    }
}
