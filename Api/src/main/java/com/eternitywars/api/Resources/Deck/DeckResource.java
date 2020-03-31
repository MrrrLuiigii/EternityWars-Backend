package com.eternitywars.api.Resources.Deck;

import com.eternitywars.api.DAL.Repositories.Deck.DeckRepository;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/public/deck")
public class DeckResource
{
    private DeckRepository deckRepository = new DeckRepository();


    @PostMapping(value = "/addCard", consumes = "application/json", produces = "application/json")
    public boolean AddCard(@RequestBody Deck deck)
    {
        return deckRepository.AddCard(deck);
    }

    @PostMapping(value = "/deleteCard", consumes = "application/json", produces = "application/json")
    public boolean DeleteCard(@RequestBody Deck deck)
    {
        return deckRepository.DeleteCard(deck);
    }

    @PostMapping(value = "/updateName", consumes = "application/json", produces = "application/json")
    public boolean UpdateDeckName(@RequestBody Deck deck)
    {
        return deckRepository.UpdateDeckName(deck);
    }
}
