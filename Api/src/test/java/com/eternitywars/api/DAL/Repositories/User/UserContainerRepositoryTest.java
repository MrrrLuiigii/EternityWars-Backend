package com.eternitywars.api.DAL.Repositories.User;

import com.eternitywars.api.Factories.User.UserContainerFactory;
import com.eternitywars.api.Models.Enums.AccountStatus;
import com.eternitywars.api.Models.User;
import com.eternitywars.api.Models.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserContainerRepositoryTest
{
    private UserContainerRepository userContainerRepository = new UserContainerRepository(new UserContainerFactory());

    private User SetupExpectedUser()
    {
        User expectedUser = new User();
        expectedUser.setUserId(1);
        expectedUser.setEmail("getUser@byEmail.nl");
        expectedUser.setUsername("expectedUser");
        expectedUser.setAccountStatus(AccountStatus.Online);
        expectedUser.setGold(250);
        expectedUser.setPackAmount(3);
        return expectedUser;
    }

    private Users SetupExpectedUserCollection()
    {
        Users expectedUsers = new Users();

        User expectedUserOne = new User();
        expectedUserOne.setUserId(1);
        expectedUserOne.setEmail("getUser@byEmail.nl");
        expectedUserOne.setUsername("expectedUser");
        expectedUserOne.setAccountStatus(AccountStatus.Online);
        expectedUserOne.setGold(250);
        expectedUserOne.setPackAmount(3);
        expectedUsers.addUser(expectedUserOne);

        User expectedUserTwo = new User();
        expectedUserTwo.setUserId(2);
        expectedUserTwo.setEmail("getUserTwo@byEmail.nl");
        expectedUserTwo.setUsername("expectedUserTwo");
        expectedUserTwo.setAccountStatus(AccountStatus.Offline);
        expectedUserTwo.setGold(300);
        expectedUserTwo.setPackAmount(2);
        expectedUsers.addUser(expectedUserTwo);

        return expectedUsers;
    }

    private User SetupNewUser()
    {
        User newUser = new User();

        newUser.setUserId(0);
        newUser.setEmail("newUser@mail.nl");
        newUser.setUsername("newUser");
        newUser.setAccountStatus(AccountStatus.InGame);
        newUser.setGold(100);
        newUser.setPackAmount(0);

        return newUser;
    }

    @Test
    void getUserById() {
        User expectedUser = SetupExpectedUser();

        User user = userContainerRepository.GetUserById(expectedUser.getUserId());

        assertEquals(expectedUser.getUserId(), user.getUserId());
        assertEquals(expectedUser.getEmail(), user.getEmail());
        assertEquals(expectedUser.getUsername(), user.getUsername());
        assertEquals(expectedUser.getAccountStatus(), user.getAccountStatus());
        assertEquals(expectedUser.getGold(), user.getGold());
        assertEquals(expectedUser.getPackAmount(), user.getPackAmount());
    }

    @Test
    void getUserByUsername() {
        User expectedUser = SetupExpectedUser();

        User user = userContainerRepository.GetUserByEmail(expectedUser.getEmail());

        assertEquals(expectedUser.getUserId(), user.getUserId());
        assertEquals(expectedUser.getEmail(), user.getEmail());
        assertEquals(expectedUser.getUsername(), user.getUsername());
        assertEquals(expectedUser.getAccountStatus(), user.getAccountStatus());
        assertEquals(expectedUser.getGold(), user.getGold());
        assertEquals(expectedUser.getPackAmount(), user.getPackAmount());
    }

    @Test
    void getUserByEmail() {
        User expectedUser = SetupExpectedUser();

        User user = userContainerRepository.GetUserByEmail(expectedUser.getEmail());

        assertEquals(expectedUser.getUserId(), user.getUserId());
        assertEquals(expectedUser.getEmail(), user.getEmail());
        assertEquals(expectedUser.getUsername(), user.getUsername());
        assertEquals(expectedUser.getAccountStatus(), user.getAccountStatus());
        assertEquals(expectedUser.getGold(), user.getGold());
        assertEquals(expectedUser.getPackAmount(), user.getPackAmount());
    }

    @Test
    void getUsers() {
        Users expectedUsers = SetupExpectedUserCollection();

        Users users = userContainerRepository.GetUsers();

        for (int i = 0; i < expectedUsers.getUsers().size(); i++)
        {
            assertEquals(expectedUsers.getUsers().get(i).getUserId(), users.getUsers().get(i).getUserId());
            assertEquals(expectedUsers.getUsers().get(i).getEmail(), users.getUsers().get(i).getEmail());
            assertEquals(expectedUsers.getUsers().get(i).getUsername(), users.getUsers().get(i).getUsername());
            assertEquals(expectedUsers.getUsers().get(i).getAccountStatus(), users.getUsers().get(i).getAccountStatus());
            assertEquals(expectedUsers.getUsers().get(i).getGold(), users.getUsers().get(i).getGold());
            assertEquals(expectedUsers.getUsers().get(i).getPackAmount(), users.getUsers().get(i).getPackAmount());
        }
    }

    @Test
    void addUser() {
        User newUser = SetupNewUser();

        int userCount = userContainerRepository.GetUsers().getUsers().size();

        User user = userContainerRepository.AddUser(newUser);

        int newUserCount = userContainerRepository.GetUsers().getUsers().size();

        assertEquals(userCount + 1, newUserCount);
        assertEquals(user.getUsername(), user.getUsername());
        assertEquals(user.getEmail(), newUser.getEmail());
        assertEquals(user.getGold(), newUser.getGold());
        assertEquals(user.getPackAmount(), newUser.getPackAmount());

        DeleteAddedUser(user);
    }

    private void DeleteAddedUser(User user)
    {
        userContainerRepository.DeleteUser(user);
    }
}