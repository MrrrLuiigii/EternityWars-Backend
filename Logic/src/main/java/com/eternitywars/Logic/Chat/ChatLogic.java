package com.eternitywars.Logic.Chat;

        import com.eternitywars.Logic.utils.APIRequest;
        import com.eternitywars.Models.Chat;
        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.google.gson.JsonObject;
        import org.json.JSONObject;
        import org.springframework.http.HttpEntity;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.HttpMethod;
        import org.springframework.http.MediaType;

public class ChatLogic
{
    public Chat SendMessage(JSONObject jsonObject)
    {
        Chat chat = (Chat)APIRequest.CreateRequest("http://localhost:8083/api/private/chat/sendMessage", jsonObject.toString(), Chat.class, HttpMethod.PUT);
        return chat;
    }

    public Chat UpdateUserStatus(JSONObject jsonObject)
    {
        Chat chat = (Chat)APIRequest.CreateRequest("http://localhost:8083/api/private/chat/sendMessage", jsonObject.toString(), Chat.class, HttpMethod.PUT);
        return null;
    }
}
