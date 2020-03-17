package com.eternitywars.api.Interfaces.Chat;

import com.eternitywars.api.Models.Entities.Chat;
import com.eternitywars.api.Models.ChatCollection;

public interface IChatContainerContext
{
    ChatCollection GetAllChats();

    Chat GetChatById(int chatId);

    boolean DeleteChat(int chatId);

    Chat CreateChat(Chat chat);
}
