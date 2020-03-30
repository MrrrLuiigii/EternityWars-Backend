package com.eternitywars.Logic.Register;

import com.eternitywars.Logic.WebsocketServer.Collection.UserCollection;
import com.eternitywars.Logic.WebsocketServer.WsModels.WsRegister;

public class RegisterLogic {

    public void Register(WsRegister wsRegister)
    {
        if(UserCollection.CheckNotRegistered(wsRegister.getParameter())){
            UserCollection.getConnectedUsers().add(wsRegister.getParameter());
            System.out.println(UserCollection.getConnectedUsers().size());
        }
    }

}
