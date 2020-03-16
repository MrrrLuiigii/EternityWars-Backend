package com.eternitywars.api.Resources.Chat;

import com.eternitywars.api.DAL.Repositories.Chat.ChatContainerRepository;
import com.eternitywars.api.DAL.Repositories.Chat.ChatRepository;
import com.eternitywars.api.Models.Entities.Chat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/private/chat")
public class ChatResource
{
    private ChatRepository chatRepository = new ChatRepository();

    @PostMapping(value = "/sendMessage", consumes = "application/json", produces = "application/json")
    public Chat SendMessage(@RequestBody Chat chat)
    {
        return chatRepository.SendMessage(chat);
    }

    @PostMapping(value = "/ChangeUserStatus", consumes = "application/json", produces = "application/json")
    public Chat ChangeUserStatus(@RequestBody Chat chat)
    {
        return chatRepository.UpdateUserStatus(chat);
    }


}
