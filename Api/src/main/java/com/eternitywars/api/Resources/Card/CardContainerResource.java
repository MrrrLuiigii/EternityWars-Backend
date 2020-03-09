package com.eternitywars.api.Resources.Card;

import com.eternitywars.api.DAL.Repositories.Card.CardContainerRepository;
import com.eternitywars.api.Models.*;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public/card")
public class CardContainerResource
{
    private CardContainerRepository cardContainerRepository = new CardContainerRepository();


    @GetMapping(value = "/getByUserId/{userId}")
    public Cards GetCardsByUser(@PathVariable("userId") int userId)
    {
        return cardContainerRepository.GetCardsByUser(userId);
    }

    @GetMapping(value = "/getById/{cardId}")
    public Card GetCardsById(@PathVariable("cardId") int cardId)
    {
        return cardContainerRepository.GetCardById(cardId);
    }

    @GetMapping(value = "/get")
    public Cards GetCards()
    {
        return cardContainerRepository.GetCards();
    }

    @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeleteCard(@RequestBody CardCollectionUpdater cardCollectionUpdater)
    {
        User user = cardCollectionUpdater.getUser();
        Card card = cardCollectionUpdater.getCard();
        return cardContainerRepository.DeleteCard(user, card);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public boolean AddCard(@RequestBody CardCollectionUpdater cardCollectionUpdater)
    {
        User user = cardCollectionUpdater.getUser();
        Card card = cardCollectionUpdater.getCard();
        return cardContainerRepository.AddCard(user, card);
    }
}
