package com.eternitywars.api.Interfaces.Chat;

import com.eternitywars.api.Models.Entities.Chat;
import com.fasterxml.jackson.databind.util.JSONPObject;

public interface IChatContext
{
    Chat SendMessage(Chat chat);

    Chat UpdateUserStatus(Chat chat);
}
