package com.eternitywars.api.DAL.Contexts.Chat;

import com.eternitywars.api.Interfaces.Chat.IChatContainerContext;
import com.eternitywars.api.Models.Entities.Chat;
import com.eternitywars.api.Models.ChatCollection;

public class ChatContainerHibernateContext implements IChatContainerContext {
    @Override
    public ChatCollection GetAllChats() {
        return null;
    }

    @Override
    public Chat GetChatById(int chatId) {
        return null;
    }

    @Override
    public boolean DeleteChat(int chatId) {
        return false;
    }

    @Override
    public Chat CreateChat(Chat chat) {
        return null;
    }
}
