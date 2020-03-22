package com.eternitywars.api.DAL.Repositories.Chat;

import com.eternitywars.api.Factories.Chat.ChatContainerFactory;
import com.eternitywars.api.Interfaces.Chat.IChatContainerContext;
import com.eternitywars.api.Models.Entities.Chat;
import com.eternitywars.api.Models.ChatCollection;
import com.eternitywars.api.Models.Entities.User;

public class ChatContainerRepository implements IChatContainerContext
{

    private IChatContainerContext chatContainerContext;

    public ChatContainerRepository() {
        this.chatContainerContext = ChatContainerFactory.getChatHibernateContext();
    }


    @Override
    public ChatCollection GetChatsByUser(User user) { return chatContainerContext.GetChatsByUser(user); }

    @Override
    public Chat GetChatById(int chatId) {
        return chatContainerContext.GetChatById(chatId);
    }

    @Override
    public boolean DeleteChat(Chat chat) {
        return chatContainerContext.DeleteChat(chat);
    }

    @Override
    public Chat CreateChat(Chat chat) {
        return chatContainerContext.CreateChat(chat);
    }
}
