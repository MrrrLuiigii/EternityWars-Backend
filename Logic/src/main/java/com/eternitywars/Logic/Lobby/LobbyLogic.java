package com.eternitywars.Logic.Lobby;

import com.eternitywars.Logic.DeckBuilder.DeckBuilderContainerLogic;
import com.eternitywars.Logic.Game.GameLogic;
import com.eternitywars.Logic.WebsocketServer.WsModels.WsFrontendUser;
import com.eternitywars.Logic.WebsocketServer.WsModels.WsJoinLobby;
import com.eternitywars.Logic.WebsocketServer.WsModels.WsLobbyModel;
import com.eternitywars.Logic.utils.APIRequest;
import com.eternitywars.Models.*;
import com.eternitywars.Models.DTO.JoinLobbyDTO;
import com.eternitywars.Models.DTO.LobbyDTO;
import com.eternitywars.Models.Enums.LobbyPlayerStatus;
import com.eternitywars.Models.Viewmodels.Lobby.LobbyViewmodel;
import com.eternitywars.Models.Viewmodels.SingleUserViewmodel;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class LobbyLogic
{
    private RestTemplate restTemplate = new RestTemplate();
    private LobbyContainerLogic lobbyContainerLogic = new LobbyContainerLogic();
    private GameLogic gameLogic = new GameLogic();

    public LobbyViewmodel JoinLobby(WsJoinLobby wsJoinLobby)
    {
        JoinLobbyDTO joinLobbyDTO = new JoinLobbyDTO();
        joinLobbyDTO.setLobbyID(wsJoinLobby.getLobby().getId());
        joinLobbyDTO.setPlayerID(wsJoinLobby.getUser().getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(wsJoinLobby.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject json = new JSONObject(joinLobbyDTO);
        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);

        String url = "http://localhost:8083/api/public/lobby/join";
        LobbyViewmodel lobbyViewmodel = restTemplate.postForObject(url, request, LobbyViewmodel.class);
        return lobbyViewmodel;
    }

    public Lobby LeaveLobby(Lobby lobby, Player player, String token)
    {
        if(lobby.getPlayers().get(1) != null)
        {
            if(lobby.getPlayers().get(1).getUserId() != 0)
            {
                HttpHeaders headers = new HttpHeaders();
                headers.setBearerAuth(token);
                headers.setContentType(MediaType.APPLICATION_JSON);
                Lobby sendlobby = new Lobby();
                sendlobby.setId(lobby.getId());
                lobby.getPlayers().set(0, player);

                JSONObject json = new JSONObject(lobby);

                HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);
                if(restTemplate.postForObject("http://localhost:8083/api/private/lobby/leave", request , boolean.class))
                {
                    lobby.getPlayers().set(1, null);
                    return lobby;
                }
            }
        }
        lobbyContainerLogic.DeleteLobby(lobby, token);
        return null;
    }

    public Lobby PlayerReady(Lobby lobby, Player player, String token)
    {
       if(lobby.getPlayers().get(0).getUserId() == player.getUserId())
       {
           lobby.getPlayers().get(0).setLobbyPlayerStatus(LobbyPlayerStatus.Ready);
       }
       else if(lobby.getPlayers().get(1).getUserId() == player.getUserId())
       {
           lobby.getPlayers().get(1).setLobbyPlayerStatus(LobbyPlayerStatus.Ready);
       }
       if(lobby.getPlayers().get(0) != null && lobby.getPlayers().get(1) != null)
       {
           if(lobby.getPlayers().get(0).getLobbyPlayerStatus() == LobbyPlayerStatus.Ready && lobby.getPlayers().get(1).getLobbyPlayerStatus() == LobbyPlayerStatus.Ready)
           {
               DeckBuilderContainerLogic deckBuilderContainerLogic = new DeckBuilderContainerLogic();
               lobby.getPlayers().get(0).setDeck(deckBuilderContainerLogic.GetDeckByIdLogic(lobby.getPlayers().get(0).getDeck().getDeckId(), token));
               lobby.getPlayers().get(1).setDeck(deckBuilderContainerLogic.GetDeckByIdLogic(lobby.getPlayers().get(1).getDeck().getDeckId(), token));
               gameLogic.LaunchGame(lobby);
               lobbyContainerLogic.DeleteLobby(lobby, token);

           }
       }
        return lobby;
    }

    public Lobby PlayerNotReady(Lobby lobby, Player player)
    {
        if(lobby.getPlayers().get(0).getUserId() == player.getUserId())
        {
            lobby.getPlayers().get(0).setLobbyPlayerStatus(LobbyPlayerStatus.NotReady);
        }
        else if(lobby.getPlayers().get(1).getUserId() == player.getUserId())
        {
            lobby.getPlayers().get(1).setLobbyPlayerStatus(LobbyPlayerStatus.NotReady);
        }
        return lobby;
    }



    public Lobby SetDeck(JSONObject jsonObject)
    {
        Lobby lobby = (Lobby)MessageHandler.HandleMessage(jsonObject.getString("content"), Lobby.class);
        Player player = (Player)MessageHandler.HandleMessage(jsonObject.getString("player"), Player.class);
        String token = jsonObject.getString("token");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(token);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        Lobby sendlobby = new Lobby();
//        sendlobby.setId(lobby.getId());
//        sendlobby.setPlayerOne(player);
//
//        JSONObject json = new JSONObject(sendlobby);
//
//        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);
//        Lobby lobby1 = restTemplate.postForObject("http://localhost:8083/api/private/lobby/updateDeck", request , Lobby.class);
        if(lobby.getPlayers().get(0).getUserId() == player.getUserId())
        {
            lobby.getPlayers().get(0).setDeck(player.getDeck());
        }
        else if(lobby.getPlayers().get(1).getUserId() == player.getUserId())
        {
            lobby.getPlayers().get(1).setDeck(player.getDeck());
        }
        return  lobby;
    }
}
