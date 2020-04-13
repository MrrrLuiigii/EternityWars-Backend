package com.eternitywars.Models;

import com.google.gson.Gson;

public class MessageHandler
{
    public static Object HandleMessage(String message, Object object)
    {
        Gson g = new Gson();
        object = g.fromJson(message, object.getClass());

        return object;
    }
}
