package com.eternitywars.api.Resources.Deck;


import com.eternitywars.api.DAL.Repositories.Deck.DeckContainerRepository;
import com.eternitywars.api.Models.Decks;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Viewmodels.Deck.DeckViewmodel;
import com.eternitywars.api.Models.Viewmodels.Deck.DecksViewmodel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public DecksViewmodel GetDecksByUserId(@PathVariable("userId") int userId)
    {
        Decks getDecks = deckContainerRepository.GetDecksByUserId(userId);

        DecksViewmodel decks = new DecksViewmodel();

        for (Deck d : getDecks.getDecks())
        {
            DeckViewmodel deck = new DeckViewmodel(
                    d.getDeckId(),
                    d.getName(),
                    d.getCards()
            );

            decks.getDecks().add(deck);
        }

        return decks;
    }

    @GetMapping(value = "/getByDeckId/{deckId}")
    public Deck GetDeckById(@PathVariable("deckId") int deckId)
    {
        return deckContainerRepository.GetDeckById(deckId);
    }
}
