package com.eternitywars.api.Resources.User;

import com.eternitywars.api.DAL.Repositories.User.UserRepository;
import com.eternitywars.api.Models.Entities.User;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/public/user")
public class UserResource
{
    private UserRepository userRepository = new UserRepository();


    @PutMapping(value = "/updateUsername", consumes = "application/json", produces = "application/json")
    public boolean UpdateUsername(@RequestBody User user)
    {
        return userRepository.UpdateUsername(user);
    }

    @PutMapping(value = "/updateAccountStatus", consumes = "application/json", produces = "application/json")
    public boolean UpdateAccountStatus(@RequestBody User user)
    {
        return userRepository.UpdateAccountStatus(user);
    }

    @PutMapping(value = "/updatePackAmount", consumes = "application/json", produces = "application/json")
    public boolean UpdatePackAmount(@RequestBody User user)
    {
        return userRepository.UpdatePackAmount(user);
    }

    @PutMapping(value = "/updateGold", consumes = "application/json", produces = "application/json")
    public boolean UpdateGold(@RequestBody User user)
    {
        return userRepository.UpdateGold(user);
    }
}
