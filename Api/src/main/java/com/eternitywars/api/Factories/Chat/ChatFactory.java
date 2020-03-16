package com.eternitywars.api.Factories.Chat;

import com.eternitywars.api.DAL.Contexts.Chat.ChatHibernateContext;
import com.eternitywars.api.Interfaces.Chat.IChatContext;

public class ChatFactory {
    public static IChatContext getChatHibernateContext()
    {
        return new ChatHibernateContext();
    }
}
