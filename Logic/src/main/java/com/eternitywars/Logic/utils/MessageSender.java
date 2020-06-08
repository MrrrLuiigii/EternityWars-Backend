package com.eternitywars.Logic.utils;


import com.eternitywars.Logic.WebsocketServer.Collection.UserCollection;
import com.eternitywars.Logic.WebsocketServer.Models.WsReturnMessage;
import com.eternitywars.Models.DTO.LobbyDTO;
import com.eternitywars.Models.Lobby;
import com.eternitywars.Models.LobbyCollection;
import com.eternitywars.Models.User;
import com.eternitywars.Models.Viewmodels.Lobby.LobbiesViewmodel;
import com.eternitywars.Models.Viewmodels.Lobby.LobbyViewmodel;

import java.io.IOException;

public class MessageSender {

    public static void UpdateParticipatingLobby(LobbyViewmodel lobby, String action) throws IOException {

        WsReturnMessage returnMessage = new WsReturnMessage();
        returnMessage.setAction(action);
        returnMessage.setContent(lobby);

        for (User u : UserCollection.getConnectedUsers()){
            if(lobby.getPlayers().get(0) != null){
                if(u.getUsername().equals(lobby.getPlayers().get(0).getUsername())){
                    u.getSession().getRemote().sendString(MessageConverter.FromObjectToString(returnMessage));
                }
            }
            if(lobby.getPlayers().get(1) != null){
                if(u.getUsername().equals(lobby.getPlayers().get(1).getUsername())){
                    u.getSession().getRemote().sendString(MessageConverter.FromObjectToString(returnMessage));
                }
            }
        }
    }


    public static void UpdateLobbyList(LobbiesViewmodel lobbies) throws IOException {
        WsReturnMessage returnMessage = new WsReturnMessage();
        returnMessage.setAction("GetLobbies");
        returnMessage.setContent(lobbies);


        for (User u : UserCollection.getConnectedUsers()) {
            u.getSession().getRemote().sendString(MessageConverter.FromObjectToString(returnMessage));
        }
    }

    public static void SendGenericMessageToUser(Object content, String action, User user) throws IOException {
        WsReturnMessage returnMessage = new WsReturnMessage();
        returnMessage.setAction(action);
        returnMessage.setContent(content);

        for (User u : UserCollection.getConnectedUsers()) {
            if (u.getUserId() == user.getUserId()) {
                u.getSession().getRemote().sendString(MessageConverter.FromObjectToString(returnMessage));
            }
        }
    }

    public static void SendError(int userid, String error) throws IOException {
        WsReturnMessage returnMessage = new WsReturnMessage();
        returnMessage.setAction("ERROR");
        returnMessage.setContent(error);

        for (User u : UserCollection.getConnectedUsers()) {
            if (u.getUserId() == userid) {
                u.getSession().getRemote().sendString(MessageConverter.FromObjectToString(returnMessage));
            }
        }
    }
}
