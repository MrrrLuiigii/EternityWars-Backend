package com.eternitywars.Logic.Lobby;

import com.eternitywars.Logic.WebsocketServer.WsModels.WsLobbyModel;
import com.eternitywars.Logic.WebsocketServer.WsModels.WsUserToken;
import com.eternitywars.Models.DTO.LobbyDTO;
import com.eternitywars.Models.DTO.LobbyPlayerDTO;
import com.eternitywars.Models.Enums.LobbyPlayerStatus;
import com.eternitywars.Models.Lobby;
import com.eternitywars.Models.LobbyCollection;
import com.eternitywars.Models.Player;
import com.eternitywars.Models.User;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class LobbyContainerLogic
{
    private RestTemplate restTemplate = new RestTemplate();



    public Lobby AddLobby(WsLobbyModel wsLobbyModel)
    {
        User user = new User();
        user.setUserId(wsLobbyModel.getUser().getId());
        user.setEmail(wsLobbyModel.getUser().getEmail());
        user.setUsername(wsLobbyModel.getUser().getUsername());
        user.setAccountStatus(wsLobbyModel.getUser().getStatus());



        LobbyPlayerDTO lobbyPlayerDTO = new LobbyPlayerDTO();
        lobbyPlayerDTO.setLobbyPlayerStatus(LobbyPlayerStatus.NotReady);
        lobbyPlayerDTO.setUser(user);
        lobbyPlayerDTO.setSelectedDeck(null);



        LobbyDTO lobbyDTO = new LobbyDTO();
        lobbyDTO.setDescription(wsLobbyModel.getParameter().getDescription());
        lobbyDTO.setName(wsLobbyModel.getParameter().getName());
        lobbyDTO.setHasPassword(wsLobbyModel.getParameter().getHasPassword());
        lobbyDTO.setPassword(wsLobbyModel.getParameter().getPassword());
        lobbyDTO.getPlayers().add(lobbyPlayerDTO);


        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(wsLobbyModel.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject json = new JSONObject(lobbyDTO);
        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);
        //send lobby object with the user that wants to join
        return restTemplate.postForObject("http://localhost:8083/api/public/lobby/add", request, Lobby.class);
    }

    public Lobby GetLobbyById(Lobby lobby, String token)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject json = new JSONObject(lobby);
        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);
        ResponseEntity<Lobby> response = restTemplate.exchange("http://localhost:8083/api/private/lobby/getById/{lobbyId}", HttpMethod.GET, request, Lobby.class, lobby.getId());
        return response.getBody();
    }

    public LobbyCollection GetLobbies(WsUserToken wsUserToken)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(wsUserToken.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<LobbyCollection> response = restTemplate.exchange("http://localhost:8083/api/public/lobby/get", HttpMethod.GET, request, LobbyCollection.class);
        return response.getBody();
    }

    public LobbyCollection DeleteLobby(Lobby lobby, String token)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject json = new JSONObject(lobby);
        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);
        restTemplate.postForObject("http://localhost:8083/api/private/lobby/delete", request, boolean.class);
        WsUserToken wsUserToken = new WsUserToken();
        wsUserToken.setToken(token);
        return  GetLobbies(wsUserToken);
    }
}
