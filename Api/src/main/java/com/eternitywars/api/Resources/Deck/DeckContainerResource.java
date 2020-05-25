package com.eternitywars.api.Resources.Deck;

import com.eternitywars.api.DAL.Repositories.Deck.DeckContainerRepository;
import com.eternitywars.api.Models.Decks;
import com.eternitywars.api.Models.Entities.Deck;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public/deck")
public class DeckContainerResource
{
    private DeckContainerRepository deckContainerRepository = new DeckContainerRepository();


    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Deck AddDeck(@RequestBody Deck deck)
    {
        return deckContainerRepository.AddDeck(deck);
    }

    @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeleteDeck(@RequestBody Deck deck)
    {
        return deckContainerRepository.DeleteDeck(deck);
    }

    @GetMapping(value = "/getByUserId/{userId}")
    public Decks GetDecksByUserId(@PathVariable("userId") int userId)
    {
        return deckContainerRepository.GetDecksByUserId(userId);
    }

    @GetMapping(value = "/getByDeckId/{deckId}")
    public Deck GetDeckById(@PathVariable("deckId") int deckId)
    {
        Deck deck = deckContainerRepository.GetDeckById(deckId);
        return deck;
    }
}
