package com.eternitywars.api.DAL.Repositories.Chat;

import com.eternitywars.api.Factories.Chat.ChatContainerFactory;
import com.eternitywars.api.Interfaces.Chat.IChatContainerContext;
import com.eternitywars.api.Models.Entities.Chat;
import com.eternitywars.api.Models.ChatCollection;

public class ChatContainerRepository implements IChatContainerContext
{

    private IChatContainerContext chatContainerContext;

    public ChatContainerRepository() {
        this.chatContainerContext = ChatContainerFactory.getChatHibernateContext();
    }

    @Override
    public ChatCollection GetAllChats() {
        return chatContainerContext.GetAllChats();
    }

    @Override
    public Chat GetChatById(int chatId) {
        return chatContainerContext.GetChatById(chatId);
    }

    @Override
    public boolean DeleteChat(int chatId) {
        return chatContainerContext.DeleteChat(chatId);
    }

    @Override
    public Chat CreateChat(Chat chat) {
        return chatContainerContext.CreateChat(chat);
    }
}
