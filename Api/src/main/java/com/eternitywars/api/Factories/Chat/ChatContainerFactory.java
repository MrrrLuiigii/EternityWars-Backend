package com.eternitywars.api.Factories.Chat;

import com.eternitywars.api.DAL.Contexts.Chat.ChatContainerHibernateContext;
import com.eternitywars.api.DAL.Contexts.Chat.ChatHibernateContext;
import com.eternitywars.api.Interfaces.Chat.IChatContainerContext;
import com.eternitywars.api.Interfaces.Chat.IChatContext;

public class ChatContainerFactory
{
    public static IChatContainerContext getChatHibernateContext()
    {
        return new ChatContainerHibernateContext();
    }
}
