package com.eternitywars.Logic.Chat;

import com.eternitywars.Logic.utils.APIRequest;
import com.eternitywars.Models.Chat;
import com.eternitywars.Models.ChatCollection;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpMethod;

public class ChatContainerLogic
{
    public ChatCollection GetAllChats(JsonObject jsonObject)
    {
        ChatCollection chatCollection = (ChatCollection) APIRequest.CreateRequest("http://localhost:8083/api/private/chat/getallchats", jsonObject.toString(), ChatCollection.class, HttpMethod.GET);
        return chatCollection;
    }

    public Chat GetChatById(JsonObject jsonObject)
    {
        Chat chat = (Chat) APIRequest.CreateRequest("http://localhost:8083/api/private/chat/getchatbyid", jsonObject.toString(), Chat.class, HttpMethod.GET);
        return chat;
    }

    public Boolean DeleteChat(JsonObject jsonObject)
    {
        if(APIRequest.CreateRequest("http://localhost:8083/api/private/chat/deletechat", jsonObject.toString(), Chat.class, HttpMethod.DELETE) != null)
        {
            return true;
        }
        return false;
    }

    public Chat CreateChat(JsonObject jsonObject)
    {
        Chat chat = (Chat) APIRequest.CreateRequest("http://localhost:8083/api/private/chat/createchat", jsonObject.toString(), Chat.class, HttpMethod.POST);
        return chat;
    }
}
