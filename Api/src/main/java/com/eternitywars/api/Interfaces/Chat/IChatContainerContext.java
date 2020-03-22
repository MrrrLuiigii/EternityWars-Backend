package com.eternitywars.api.Interfaces.Chat;

import com.eternitywars.api.Models.Entities.Chat;
import com.eternitywars.api.Models.ChatCollection;
import com.eternitywars.api.Models.Entities.User;

public interface IChatContainerContext
{
    ChatCollection GetChatsByUser(User user);

    Chat GetChatById(int chatId);

    boolean DeleteChat(Chat chat);

    Chat CreateChat(Chat chat);
}
