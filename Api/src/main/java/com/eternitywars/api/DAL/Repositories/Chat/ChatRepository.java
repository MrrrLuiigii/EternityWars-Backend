package com.eternitywars.api.DAL.Repositories.Chat;

import com.eternitywars.api.Interfaces.Chat.IChatContext;
import com.eternitywars.api.Models.Entities.Chat;

public class ChatRepository implements IChatContext
{
    private IChatContext chatContext;


    @Override
    public Chat SendMessage(Chat chat) {
        return chatContext.SendMessage(chat);
    }

    @Override
    public Chat UpdateUserStatus(Chat chat) {
        return chatContext.UpdateUserStatus(chat);
    }
}
