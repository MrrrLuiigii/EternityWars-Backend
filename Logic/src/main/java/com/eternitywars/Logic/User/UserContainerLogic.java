package com.eternitywars.Logic.User;

import com.eternitywars.Logic.WebsocketServer.WsModels.WsAddUser;
import com.eternitywars.Logic.WebsocketServer.WsModels.WsGetByEmail;
import com.eternitywars.Models.Enums.AccountStatus;
import com.eternitywars.Models.User;
import com.eternitywars.Models.Users;
import com.eternitywars.Models.Viewmodels.SingleUserViewmodel;
import com.eternitywars.Models.Viewmodels.UserViewmodel;
import com.eternitywars.Models.Viewmodels.UsersViewmodel;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class UserContainerLogic
{
    private RestTemplate restTemplate = new RestTemplate();
    private Gson gson;

    public UsersViewmodel GetUsers(String token)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<UsersViewmodel> response = restTemplate.exchange("http://localhost:8083/api/public/user/get" , HttpMethod.GET, request, UsersViewmodel.class);

        return response.getBody();
    }

    public User AddUser(WsAddUser wsAddUser)
    {
        User user = wsAddUser.getUser();
        String token = wsAddUser.getToken();

        if(CheckUserTaken(GetUsers(token), user))
        {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject userJson = new JSONObject(user);
            HttpEntity<String> request = new HttpEntity<>(userJson.toString(), headers);

            ResponseEntity<User> response = restTemplate.exchange("http://localhost:8083/api/public/user/add" , HttpMethod.POST, request, User.class);
            return response.getBody();
        }
        return null;
    }

    private Users GetUserCollectionFromAPI(String token)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        return restTemplate.postForObject("http://localhost:8083/api/private/user/get", request, Users.class);
    }

    public SingleUserViewmodel GetUserByEmail(WsGetByEmail wsGetByEmail)
    {
        String email = wsGetByEmail.getParameter();
        String token = wsGetByEmail.getToken();
        System.out.println(token);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<SingleUserViewmodel> response = restTemplate.exchange("http://localhost:8083/api/public/user/getByEmail/{email}", HttpMethod.GET, request , SingleUserViewmodel.class, email);


        return response.getBody();
    }

    public SingleUserViewmodel GetUserById(User user)
    {

        //String token = json.getString("Token");
        //System.out.println(token);
        JSONObject output = new JSONObject(user);

        HttpHeaders headers = new HttpHeaders();
        //headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(output.toString(), headers);

        ResponseEntity<SingleUserViewmodel> response = restTemplate.exchange("localhost:8083/api/private/user/getByEmail/", HttpMethod.GET, request, SingleUserViewmodel.class);
        return response.getBody();
    }



    private boolean CheckUserTaken(UsersViewmodel users, User user)
    {
        for (UserViewmodel u : users.getUsers())
        {
            if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail()))
            {
                return false;
            }
        }
        return true;
    }

    public SingleUserViewmodel getUserByUsername(String friendname, String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<SingleUserViewmodel> response = restTemplate.exchange("http://localhost:8083/api/private/user/getByUsername/{friendname}", HttpMethod.GET, request , SingleUserViewmodel.class, friendname);

        return response.getBody();

    }


}
