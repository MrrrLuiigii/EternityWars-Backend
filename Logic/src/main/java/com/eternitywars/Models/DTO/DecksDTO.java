package com.eternitywars.Models.DTO;



import com.eternitywars.Models.Deck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DecksDTO {

    private List<DeckDTO> decks;

    public DecksDTO()
    {
        this.decks = new ArrayList<>();
    }

    public List<DeckDTO> getDecks()
    {
        return decks;
    }

    public void AddDeck(DeckDTO deck){ decks.add(deck);}
}
