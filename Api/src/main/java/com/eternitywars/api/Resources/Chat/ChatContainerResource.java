package com.eternitywars.api.Resources.Chat;

import com.eternitywars.api.DAL.Repositories.Chat.ChatContainerRepository;
import com.eternitywars.api.Models.Entities.Chat;
import com.eternitywars.api.Models.Entities.ChatCollection;
import com.eternitywars.api.Models.Entities.Deck;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/private/chat")
public class ChatContainerResource
{
    private ChatContainerRepository chatContainerRepository = new ChatContainerRepository();

    @PostMapping(value = "/all", consumes = "application/json", produces = "application/json")
    public ChatCollection GetAllChats()
    {
        return chatContainerRepository.GetAllChats();
    }

    @GetMapping(value = "/get/{chatId}")
    public Chat GetChatById(@PathVariable("chatId") int chatId)
    {
        return chatContainerRepository.GetChatById(chatId);
    }

    @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeleteChat(@RequestBody Chat chat)
    {
        return chatContainerRepository.DeleteChat(chat.getChatId());
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public Chat CreateChat(@RequestBody Chat chat)
    {
        return chatContainerRepository.CreateChat(chat);
    }
}
